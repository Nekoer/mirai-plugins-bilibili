package com.hcyacg

import com.hcyacg.config.Setting
import com.hcyacg.entity.*
import com.hcyacg.utils.ImageUtil
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import net.mamoe.mirai.Bot
import net.mamoe.mirai.contact.SendMessageFailedException
import net.mamoe.mirai.message.data.*
import net.mamoe.mirai.utils.ExternalResource.Companion.toExternalResource
import net.mamoe.mirai.utils.ExternalResource.Companion.uploadAsImage
import net.mamoe.mirai.utils.MiraiLogger
import okhttp3.Headers
import okhttp3.RequestBody
import org.apache.commons.lang3.StringUtils
import java.sql.Timestamp

object GroupSender {
    private val requestBody: RequestBody? = null
    private val headers = Headers.Builder()
    private val logger = MiraiLogger.Factory.create(this::class.java)
    private val json = Json { ignoreUnknownKeys = true }

    suspend fun GroupSender.sendMessage(biliBiliArticle: Article) {
        val imageList = mutableListOf<String>()
        Bot.instances.forEach { bot ->
            bot.groups.forEach here@{ group ->
                if (Setting.groups.isEmpty()) {
                    return@here
                }
                if (Setting.groups.indexOf(group.id) == -1) {
                    return@here
                }
                run {
                    try {
                        if (imageList.isEmpty()) {


                            if (null != biliBiliArticle.bannerUrl && StringUtils.isNotBlank(biliBiliArticle.bannerUrl)) {
                                val toExternalResource =
                                    ImageUtil.getImage(biliBiliArticle.bannerUrl).toByteArray()
                                        .toExternalResource()
                                val imageId: String = toExternalResource.uploadAsImage(group).imageId
                                toExternalResource.close()
                                imageList.add(imageId)
                            } else if (null != biliBiliArticle.originImageUrls && biliBiliArticle.originImageUrls.isNotEmpty()) {
                                for (img in biliBiliArticle.originImageUrls) {
                                    val toExternalResource =
                                        ImageUtil.getImage(img).toByteArray()
                                            .toExternalResource()
                                    val imageId: String = toExternalResource.uploadAsImage(group).imageId
                                    toExternalResource.close()
                                    imageList.add(imageId)
                                }
                            }
                        }
                        var message: Message = PlainText("${biliBiliArticle.author?.name} 发表了新专栏文章").plus("\n")
                            .plus("======").plus("\n")

                        imageList.forEach {
                            message = message.plus(Image(it)).plus("\n")
                        }

                        message = message.plus(biliBiliArticle.title!!).plus("\n")
                            .plus(biliBiliArticle.summary!!).plus("\n")
                            .plus("https://www.bilibili.com/read/cv${biliBiliArticle.id!!}")

                        group.sendMessage(message)
                    } catch (e: Exception) {
                        logger.error(e)
                    }
                }
            }
        }
    }
    suspend fun GroupSender.sendMessage(biliBiliVideo: BiliBiliVideoCard) {
        val imageList = mutableListOf<String>()
        Bot.instances.forEach { bot ->

            bot.groups.forEach here@{ group ->
                if (Setting.groups.isEmpty()) {
                    return@here
                }
                if (Setting.groups.indexOf(group.id) == -1) {
                    return@here
                }
                run {
                    var message: Message = PlainText("")
                    try {
                        if (imageList.isEmpty()) {
                            val toExternalResource =
                                ImageUtil.getImage(biliBiliVideo.pic!!).toByteArray().toExternalResource()
                            val imageId: String = toExternalResource.uploadAsImage(group).imageId
                            toExternalResource.close()
                            imageList.add(imageId)
                        }
                        message = PlainText("${biliBiliVideo.owner?.name} 发表了新视频").plus("\n")
                            .plus("======").plus("\n")

                        imageList.forEach {
                            message = message.plus(Image(it)).plus("\n")
                        }

                        message = message.plus(biliBiliVideo.title!!).plus("\n")
                            .plus(biliBiliVideo.desc!!).plus("\n")
                            .plus(biliBiliVideo.shortLink!!)

                        if (Setting.enable.video_At_All) {
                            group.sendMessage(AtAll.plus(message))
                        } else {
                            group.sendMessage(message)
                        }
                    } catch (e: SendMessageFailedException) {
                        group.sendMessage(message)
                    } catch (e: Exception) {
                        logger.error(e)
                    }
                }
            }
        }
    }
    suspend fun GroupSender.sendMessage(biliBiliLive: BiliBiliLive) {

        if (biliBiliLive.data == null) {
            return
        }
        val imageList = mutableListOf<String>()
        Bot.instances.forEach { bot ->

            bot.groups.forEach here@{ group ->
                if (Setting.groups.isEmpty()) {
                    return@here
                }
                if (Setting.groups.indexOf(group.id) == -1) {
                    return@here
                }

                run {
                    try {
                        if (null == biliBiliLive.data.liveRoom) {
                            return
                        }
                        if (imageList.isEmpty()) {
                            val toExternalResource =
                                ImageUtil.getImage(biliBiliLive.data.liveRoom.cover!!).toByteArray()
                                    .toExternalResource()
                            val imageId: String = toExternalResource.uploadAsImage(group).imageId
                            toExternalResource.close()
                            imageList.add(imageId)
                        }

                        var message: Message = PlainText(biliBiliLive.data.name!!)
                        if (biliBiliLive.data.liveRoom.liveStatus == 0) {
                            message = message.plus("下播了")
                        } else if (biliBiliLive.data.liveRoom.liveStatus == 1) {
                            message = message.plus("开播了")

                            imageList.forEach {
                                message = message.plus(Image(it)).plus("\n")
                            }

                            message = message.plus("${biliBiliLive.data.liveRoom.title}").plus("\n")
                                .plus("${biliBiliLive.data.liveRoom.url}")
                        }
                        group.sendMessage(message)
                    } catch (e: Exception) {
                        logger.error(e)
                    }
                }
            }
        }
    }

    @OptIn(ExperimentalSerializationApi::class)
    suspend fun GroupSender.sendMessage(biliBiliForWard: BiliBiliForWard) {

        val imageList = mutableListOf<String>()

        val json = json.decodeFromString<OriginJson>(biliBiliForWard.origin.toString())

        Bot.instances.forEach { bot ->

            bot.groups.forEach here@{ group ->
                if (Setting.groups.isEmpty()) {
                    return@here
                }
                if (Setting.groups.indexOf(group.id) == -1) {
                    return@here
                }
                run {
                    try {
                        if (imageList.isEmpty()) {
                            json.item?.pictures?.forEach {
                                val toExternalResource =
                                    ImageUtil.getImage(it.imgSrc!!).toByteArray().toExternalResource()
                                val imageId: String = toExternalResource.uploadAsImage(group).imageId
                                imageList.add(imageId)
                                toExternalResource.close()
                            }
                        }


                        var message: MessageChain = PlainText("${biliBiliForWard.user?.uname!!} 转发了".plus("\n"))
                            .plus("======").plus("\n")
                            .plus(biliBiliForWard.item?.content!!).plus("\n")
                            .plus(json.item?.description!!).plus("\n")

                        imageList.forEach {
                            message = message.plus(Image(it)).plus("\n")
                        }

                        group.sendMessage(message)
                    } catch (e: Exception) {
                        logger.error(e)
                    }

                }
            }
        }
    }

    suspend fun GroupSender.sendMessage(biliBiliText: BiliBiliText, dynamicIdStr: String) {
        if (biliBiliText.item == null) {
            return
        }


        Bot.instances.forEach { bot ->

            bot.groups.forEach here@{ group ->
                if (Setting.groups.isEmpty()) {
                    return@here
                }
                if (Setting.groups.indexOf(group.id) == -1) {
                    return@here
                }

                run {
                    try {

                        if (null == biliBiliText.item.content) {
                            return
                        }

                        if (null == biliBiliText.user) {
                            return
                        }
                        val message: Message = PlainText(biliBiliText.user.uname!!).plus("发布了新动态").plus("\n")
                            .plus("======").plus("\n")
                            .plus(biliBiliText.item.content).plus("\n")
                            .plus("https://t.bilibili.com/${dynamicIdStr}").plus("\n")

                        group.sendMessage(message)
                    } catch (e: Exception) {
                        logger.error(e)
                    }
                }
            }
        }
    }

    suspend fun GroupSender.sendMessage(biliBiliTextAndImage: BiliBiliTextAndImage, dynamicIdStr: String) {
        val imageList = mutableListOf<String>()

        if (biliBiliTextAndImage.item == null) {
            return
        }

        Bot.instances.forEach { bot ->

            bot.groups.forEach here@{ group ->
                if (Setting.groups.isEmpty()) {
                    return@here
                }
                if (Setting.groups.indexOf(group.id) == -1) {
                    return@here
                }

                run {
                    try {
                        println(biliBiliTextAndImage)
                        if (null == biliBiliTextAndImage.item.pictures) {
                            return
                        }

                        if (imageList.isEmpty()) {
                            biliBiliTextAndImage.item.pictures.forEach {
                                val toExternalResource =
                                    ImageUtil.getImage(it.imgSrc!!).toByteArray().toExternalResource()
                                val imageId: String = toExternalResource.uploadAsImage(group).imageId
                                imageList.add(imageId)
                                toExternalResource.close()
                            }
                        }

                        if (null == biliBiliTextAndImage.user) {
                            return
                        }
                        var message: Message = PlainText("${biliBiliTextAndImage.user.name}").plus("发布了新动态").plus("\n")
                            .plus("======").plus("\n")
                            .plus("${biliBiliTextAndImage.item.description}").plus("\n")

                        imageList.forEach {
                            message = message.plus(Image(it)).plus("\n")
                        }

                        message = message.plus("https://t.bilibili.com/${dynamicIdStr}").plus("\n")

                        group.sendMessage(message)
                    } catch (e: Exception) {
                        logger.error(e)
                    }
                }
            }
        }
    }

    @OptIn(ExperimentalSerializationApi::class)
    private suspend fun GroupSender.sendMessageItem(biliBiliDynamic: BiliBiliDynamic) {
        Bot.instances.forEach { bot ->

            bot.groups.forEach here@{ group ->
                if (Setting.groups.isEmpty()) {
                    return@here
                }
                if (Setting.groups.indexOf(group.id) == -1) {
                    return@here
                }

                run {
                    try {
                        val num = biliBiliDynamic.data?.cards?.get(0)?.desc?.type
                        if (null != num) {
                            if (num == 64) {
                                val biliBiliForWard =
                                    json.decodeFromString<BiliBiliForWard>(biliBiliDynamic.data.cards[0].card.toString())
                                val article = json.decodeFromString<Article>(biliBiliForWard.origin.toString())


                                group.sendMessage(

                                    PlainText("${biliBiliDynamic.data.cards[0].desc?.userProfile?.info?.uname}转发了文章").plus(
                                        "\n"
                                    )
                                        .plus(biliBiliForWard.item?.content!!).plus("\n")
                                        .plus("======").plus("\n")
                                        .plus(">>> ${article.author?.name}").plus("\n")
                                        .plus(article.title!!).plus("\n")
                                        .plus("https://t.bilibili.com/${biliBiliDynamic.data.cards[0].desc?.dynamicIdStr}")
                                )

                            }

                            if (num == 2 || num == 4) {
                                val biliBiliForWard =
                                    json.decodeFromString<BiliBiliForWard>(biliBiliDynamic.data.cards[0].card.toString())
                                val biliBiliDynamicItem =
                                    json.decodeFromString<BiliBiliDynamicItem>(biliBiliForWard.origin.toString())

                                group.sendMessage(
                                    PlainText("${biliBiliDynamic.data.cards[0].desc?.userProfile?.info?.uname}转发了内容").plus(
                                        "\n"
                                    )
                                        .plus(biliBiliForWard.item?.content!!).plus("\n")
                                        .plus("======").plus("\n")
                                        .plus(">>> ${if (null == biliBiliDynamicItem.item?.description) biliBiliDynamicItem.item?.content!! else biliBiliDynamicItem.item?.description!!}")
                                        .plus("\n")
                                        .plus("https://t.bilibili.com/${biliBiliDynamic.data.cards[0].desc?.dynamicIdStr}")
                                )
                            }

                            if (num == 8) {
                                val biliBiliForWard =
                                    json.decodeFromString<BiliBiliForWard>(biliBiliDynamic.data.cards[0].card.toString())
                                val biliBiliVideo =
                                    json.decodeFromString<BiliBiliVideoCard>(biliBiliForWard.origin.toString())


                                group.sendMessage(
                                    PlainText("${biliBiliDynamic.data.cards[0].desc?.userProfile?.info?.uname} 转发了视频").plus(
                                        "\n"
                                    )
                                        .plus(biliBiliForWard.item?.content!!).plus("\n")
                                        .plus("======").plus("\n")
                                        .plus(">>> ${biliBiliVideo.owner?.name}").plus("\n")
                                        .plus(biliBiliVideo.title!!).plus("\n")
                                        .plus("https://t.bilibili.com/${biliBiliDynamic.data.cards[0].desc?.dynamicIdStr}")
                                );
                            }

                        }
                    } catch (e: Exception) {
                        logger.error(e)
                    }

                }
            }
        }
    }

    @OptIn(ExperimentalSerializationApi::class)
    suspend fun GroupSender.sendMessage(biliBiliDynamic: BiliBiliDynamic) {

        //转发
        if (biliBiliDynamic.data?.cards?.get(0)?.desc?.type == 1) {
            if (!Setting.enable.forward) {
                return
            }
            val biliBiliForWard = json.decodeFromString<BiliBiliForWard>(biliBiliDynamic.data.cards[0].card.toString())

            if (null != biliBiliDynamic.data.cards[0].desc) {
                sendMessageItem(biliBiliDynamic)
                return
            }
            sendMessage(biliBiliForWard)
            return
        }

        //视频
        if (biliBiliDynamic.data?.cards?.get(0)?.desc?.type == 8) {
            if (!Setting.enable.video) {
                return
            }
            val biliBiliVideoCard =
                json.decodeFromString<BiliBiliVideoCard>(biliBiliDynamic.data.cards[0].card.toString())

            sendMessage(biliBiliVideoCard)
            return
        }
        //专栏
        if (biliBiliDynamic.data?.cards?.get(0)?.desc?.type == 64) {
            if (!Setting.enable.article) {
                return
            }
            val biliBiliArticle = json.decodeFromString<Article>(biliBiliDynamic.data.cards[0].card.toString())


            sendMessage(biliBiliArticle)
            return
        }
        //文本
        if (biliBiliDynamic.data?.cards?.get(0)?.desc?.type == 4) {
            if (!Setting.enable.dynamic) {
                return
            }
            println(biliBiliDynamic.data.cards[0])
            val biliBiliText = json.decodeFromString<BiliBiliText>(biliBiliDynamic.data.cards[0].card.toString())

            sendMessage(biliBiliText, biliBiliDynamic.data.cards[0].desc?.dynamicIdStr!!)
            return
        }
        //文本+图片
        if (biliBiliDynamic.data?.cards?.get(0)?.desc?.type == 2) {
            if (!Setting.enable.dynamic) {
                return
            }
            val biliBiliTextAndImage =
                json.decodeFromString<BiliBiliTextAndImage>(biliBiliDynamic.data.cards[0].card.toString())

            sendMessage(biliBiliTextAndImage, biliBiliDynamic.data.cards[0].desc?.dynamicIdStr!!)
            return
        }

    }

}