package com.hcyacg.bilibili


import com.hcyacg.GroupSender
import com.hcyacg.GroupSender.sendMessage
import com.hcyacg.config.Data
import com.hcyacg.config.Setting
import com.hcyacg.entity.*
import com.hcyacg.utils.ImageUtil
import com.hcyacg.utils.Method
import com.hcyacg.utils.RequestUtil
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import net.mamoe.mirai.contact.nameCardOrNick
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.*
import net.mamoe.mirai.utils.ExternalResource.Companion.toExternalResource
import net.mamoe.mirai.utils.ExternalResource.Companion.uploadAsImage
import net.mamoe.mirai.utils.MiraiLogger
import okhttp3.*
import okhttp3.internal.ignoreIoExceptions
import org.apache.commons.lang3.StringUtils
import java.util.*


object BiliBiliCenter {
    private val headers = Headers.Builder()
    private var requestBody: RequestBody? = null
    private val logger = MiraiLogger.Factory.create(this::class.java)
    private const val bilibiliLiveV2 = "https://api.bilibili.com/x/space/acc/info?mid="
    private const val dynamic = "https://api.vc.bilibili.com/dynamic_svr/v1/dynamic_svr/space_history"
    private val json = Json { ignoreUnknownKeys = true }
//    private var flag = false

    fun load() {
        live()
        dynamic()
    }


    @OptIn(ExperimentalSerializationApi::class)
    private fun live() {
        Timer().schedule(object : TimerTask() {
            override fun run() {
                try {
                    Setting.ups.forEach { up ->
                        logger.info("正在查看B站ID为 $up 的直播状态中")
                        val result = RequestUtil.requestObject(
                            Method.GET, "$bilibiliLiveV2${up}&jsonp=jsonp",
                            requestBody, headers.build(),
                            logger
                        ) ?: return

                        val biliBiliLive = json.decodeFromString<BiliBiliLive>(result)

                        if (biliBiliLive.code != 0) {
                            return
                        }

                        if (biliBiliLive.data == null) {
                            return
                        }
                        if (null == biliBiliLive.data.liveRoom) {
                            return
                        }
                        if (null == Data.live[up]) {
                            Data.live[up] = 0
                        }


                        if (Data.live[up] != biliBiliLive.data.liveRoom.liveStatus && biliBiliLive.data.liveRoom.liveStatus == 1) {
                            runBlocking {
                                Data.live[up] = biliBiliLive.data.liveRoom.liveStatus
                                GroupSender.sendMessage(biliBiliLive)
                                delay(1000L)
                            }
                        } else if (Data.live[up] != biliBiliLive.data.liveRoom.liveStatus && biliBiliLive.data.liveRoom.liveStatus == 0 && Data.live[up] != -1) {
                            Data.live[up] = -1
                            runBlocking {
                                GroupSender.sendMessage(biliBiliLive)
                                delay(1000L)
                            }
                        }
                    }
                } catch (e: Exception) {
                    logger.error(e)
                }
            }
        }, Date(), 60000L)
    }

    @OptIn(ExperimentalSerializationApi::class)
    private fun dynamic() {
        Timer().schedule(object : TimerTask() {
            override fun run() {
                try {
                    Setting.ups.forEach here@{ up ->
                        logger.info("正在更新B站ID为 $up 的数据中")
                        var upData = Data.dynamic[up]

                        requestBody = FormBody.Builder()
                            .add("host_uid", up)
                            .build()

                        val result = RequestUtil.requestObject(
                            Method.POST, dynamic,
                            requestBody, headers.build(),
                            logger
                        ) ?: return

                        val biliBiliDynamic = json.decodeFromString<BiliBiliDynamic>(result)

                        if (null == upData) {
                            upData = mutableMapOf()
                            upData["dynamicTimeStamp"] = "0"
                            upData["id"] = "0"
                        }


                        if (StringUtils.equals(upData["id"], "0")) {
                            if (biliBiliDynamic.data?.cards?.isEmpty() == true) {
                                upData["id"] = "1"
                                Data.dynamic[up] = upData
                                return@here
                            }

                            upData["id"] = biliBiliDynamic.data?.cards?.get(0)?.desc?.dynamicIdStr.toString()
                            upData["dynamicTimeStamp"] = biliBiliDynamic.data?.cards?.get(0)?.desc?.timestamp.toString()
                            Data.dynamic[up] = upData
                            return@here
                        } else if (biliBiliDynamic.data?.cards?.isNotEmpty() == true && !StringUtils.equals(
                                upData["id"],
                                biliBiliDynamic.data.cards[0].desc?.dynamicIdStr
                            )
                        ) {
                            runBlocking {
                                upData["id"] = biliBiliDynamic.data.cards[0].desc?.dynamicIdStr.toString()

                                if (upData["dynamicTimeStamp"]?.toLong() != 0L && upData["dynamicTimeStamp"]?.toLong()!! < biliBiliDynamic.data.cards[0].desc?.timestamp!!) {
                                    upData["dynamicTimeStamp"] =
                                        biliBiliDynamic.data.cards[0].desc?.timestamp!!.toString()
                                    GroupSender.sendMessage(biliBiliDynamic)
                                } else if (upData["dynamicTimeStamp"]?.toLong() == 0L) {
                                    upData["dynamicTimeStamp"] =
                                        biliBiliDynamic.data.cards[0].desc?.timestamp!!.toString()
                                    GroupSender.sendMessage(biliBiliDynamic)
                                }
                                Data.dynamic[up] = upData
                                delay(1000L)
                            }
                        }
                    }
                } catch (e: Exception) {
                    logger.error(e)
                }
            }
        }, Date(), 60000L)
    }


    @OptIn(ExperimentalSerializationApi::class)
    fun statistical(event: GroupMessageEvent) {
        runBlocking {
            logger.info("正在统计监控列表")
            event.subject.sendMessage(At(event.sender).plus("正在统计监控列表"))
            val nodes = mutableListOf<ForwardMessage.Node>()

            Setting.ups.forEach here@{ up ->
                val result = RequestUtil.requestObject(
                    Method.GET, "$bilibiliLiveV2${up}&jsonp=jsonp",
                    requestBody, headers.build(),
                    logger
                )
                val biliBiliLive = json.decodeFromString<BiliBiliLive>(result.toString())

                if (biliBiliLive.data == null) {
                    return@here
                }

                val toExternalResource =
                    ImageUtil.getImage(biliBiliLive.data.face!!).toByteArray().toExternalResource()
                val imageId: String = toExternalResource.uploadAsImage(event.group).imageId
                toExternalResource.close()

                val message: MessageChain = Image(imageId).plus("\n")
                    .plus("等级: Lv.${biliBiliLive.data.level}").plus("\n")
                    .plus("名字: ${biliBiliLive.data.name}").plus("\n")
                    .plus("简介: ${biliBiliLive.data.sign}").plus("\n")

                nodes.add(
                    ForwardMessage.Node(
                        senderId = event.bot.id,
                        senderName = event.bot.nameCardOrNick,
                        time = System.currentTimeMillis().toInt(),
                        message = message
                    )
                )
            }

            //合并QQ消息 发送查询到的图片线索
            val forward = RawForwardMessage(nodes).render(object : ForwardMessage.DisplayStrategy {
                override fun generateTitle(forward: RawForwardMessage): String {
                    return "正在监控的UP主们"
                }

                override fun generateSummary(forward: RawForwardMessage): String {
                    return "查看${nodes.size}条"
                }
            })

            event.subject.sendMessage(forward)
        }
    }
}

