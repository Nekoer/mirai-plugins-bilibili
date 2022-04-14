package com.hcyacg

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import com.hcyacg.config.Setting
import com.hcyacg.entity.*
import com.hcyacg.utils.ImageUtil
import net.mamoe.mirai.Bot
import net.mamoe.mirai.message.data.*
import net.mamoe.mirai.utils.ExternalResource.Companion.toExternalResource
import net.mamoe.mirai.utils.ExternalResource.Companion.uploadAsImage
import net.mamoe.mirai.utils.MiraiLogger
import okhttp3.Headers
import okhttp3.RequestBody
import org.apache.commons.lang3.StringUtils

object GroupSender {
    private val requestBody: RequestBody? = null
    private val headers = Headers.Builder()
    private val logger = MiraiLogger.Factory.create(this::class.java)


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

                    try {
                        if (imageList.isEmpty()) {
                            val toExternalResource =
                                ImageUtil.getImage(biliBiliVideo.pic!!).toByteArray().toExternalResource()
                            val imageId: String = toExternalResource.uploadAsImage(group).imageId
                            toExternalResource.close()
                            imageList.add(imageId)
                        }
                        var message: Message = PlainText("${biliBiliVideo.owner?.name} 发表了新视频").plus("\n")
                            .plus("======").plus("\n")

                        imageList.forEach {
                            message = message.plus(Image(it)).plus("\n")
                        }

                        message = message.plus(biliBiliVideo.title!!).plus("\n")
                            .plus(biliBiliVideo.desc!!).plus("\n")
                            .plus(biliBiliVideo.shortLink!!)

                        group.sendMessage(message)
                    } catch (e: Exception) {
                        logger.error(e)
                    }
                }
            }
        }
    }

    suspend fun GroupSender.sendMessage(biliBiliLive: BiliBiliLive) {
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
                            val toExternalResource =
                                ImageUtil.getImage(biliBiliLive.data.liveRoom.cover).toByteArray().toExternalResource()
                            val imageId: String = toExternalResource.uploadAsImage(group).imageId
                            toExternalResource.close()
                            imageList.add(imageId)
                        }

                        var message: Message = PlainText(biliBiliLive.data.name)
                        if (biliBiliLive.data.liveRoom.liveStatus == 0) {
                            message = message.plus("下播了")
                        } else if (biliBiliLive.data.liveRoom.liveStatus == 1) {
                            message = message.plus("开播了")

                            imageList.forEach {
                                message = message.plus(Image(it)).plus("\n")
                            }

                            message = message.plus(biliBiliLive.data.liveRoom.title).plus("\n")
                                .plus(biliBiliLive.data.liveRoom.url)
                        }
                        group.sendMessage(message)
                    } catch (e: Exception) {
                        logger.error(e)
                    }
                }
            }
        }
    }

    suspend fun GroupSender.sendMessage(biliBiliForWard: BiliBiliForWard) {

        val imageList = mutableListOf<String>()

        val json = JSON.parseObject(biliBiliForWard.origin, OriginJson::class.java)

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
                        val num = biliBiliDynamic.data?.cards?.get(0)?.desc?.origin?.type
                        if (null != num) {
                            if (num == 64) {
                                val biliBiliForWard = JSON.parseObject(
                                    JSONObject.parseObject(biliBiliDynamic.data.cards[0].card).toString(),
                                    BiliBiliForWard::class.java
                                )
                                val article = JSON.parseObject(
                                    JSONObject.parseObject(biliBiliForWard.origin).toString(),
                                    Article::class.java
                                )

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
                                val biliBiliForWard = JSON.parseObject(
                                    JSONObject.parseObject(biliBiliDynamic.data.cards[0].card).toString(),
                                    BiliBiliForWard::class.java
                                )
                                val biliBiliDynamicItem = JSON.parseObject(
                                    JSONObject.parseObject(biliBiliForWard.origin).toString(),
                                    BiliBiliDynamicItem::class.java
                                )

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
                                val biliBiliForWard = JSON.parseObject(
                                    JSONObject.parseObject(biliBiliDynamic.data.cards[0].card).toString(),
                                    BiliBiliForWard::class.java
                                )

                                val biliBiliVideo = JSON.parseObject(
                                    JSONObject.parseObject(biliBiliForWard.origin).toString(),
                                    BiliBiliVideoCard::class.java
                                )

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

    suspend fun GroupSender.sendMessage(biliBiliDynamic: BiliBiliDynamic) {

        //转发
        if (biliBiliDynamic.data?.cards?.get(0)?.desc?.type == 1) {
            val biliBiliForWard = JSON.parseObject(
                JSONObject.parseObject(biliBiliDynamic.data.cards[0].card).toString(),
                BiliBiliForWard::class.java
            )
            if (null != biliBiliDynamic.data.cards[0].desc?.origin) {
                sendMessageItem(biliBiliDynamic)
                return
            }
            sendMessage(biliBiliForWard)
            return
        }

        //视频
        if (biliBiliDynamic.data?.cards?.get(0)?.desc?.type == 8) {
            val biliBiliVideoCard = JSON.parseObject(
                JSONObject.parseObject(biliBiliDynamic.data.cards[0].card).toString(),
                BiliBiliVideoCard::class.java
            )
            sendMessage(biliBiliVideoCard)
            return
        }
        //专栏
        if (biliBiliDynamic.data?.cards?.get(0)?.desc?.type == 64) {
            val biliBiliArticle = JSON.parseObject(
                JSONObject.parseObject(biliBiliDynamic.data.cards[0].card).toString(),
                Article::class.java
            )
            sendMessage(biliBiliArticle)
            return
        }

        //文本 | 文本+图片
        if (biliBiliDynamic.data?.cards?.get(0)?.desc?.type == 4 || biliBiliDynamic.data?.cards?.get(0)?.desc?.type == 2) {
            val biliBiliDynamicItem = JSON.parseObject(
                JSONObject.parseObject(biliBiliDynamic.data.cards[0].card).toString(),
                BiliBiliDynamicItem::class.java
            )

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

                            var message: MessageChain = PlainText(
                                "${if (null != biliBiliDynamicItem.user?.name) biliBiliDynamicItem.user.name else biliBiliDynamicItem.user?.uname}B站动态更新了".plus(
                                    "\n"
                                )
                            )
                                .plus("======").plus("\n")
                                .plus("${if (null != biliBiliDynamicItem.item?.description) biliBiliDynamicItem.item?.description else biliBiliDynamicItem.item?.content}")
                                .plus("\n")

                            if (biliBiliDynamic.data.cards.isNotEmpty() && biliBiliDynamic.data.cards[0].display?.richText.toString()
                                    .isNotBlank() && biliBiliDynamic.data.cards[0].display?.richText?.richDetails?.isNotEmpty() == true
                            ) {
                                if (null != biliBiliDynamic.data.cards[0].display?.richText?.richDetails?.get(0)?.text) {
                                    message =
                                        message.plus(biliBiliDynamic.data.cards[0].display?.richText!!.richDetails[0].text)
                                            .plus("\n")
                                }
                                if (null != biliBiliDynamic.data.cards[0].display?.richText?.richDetails?.get(0)?.jumpUri) {
                                    message =
                                        message.plus(biliBiliDynamic.data.cards[0].display?.richText!!.richDetails[0].jumpUri)
                                            .plus("\n")
                                }
                            }

                            if (biliBiliDynamic.data.cards.isNotEmpty() && biliBiliDynamic.data.cards[0].display?.topicInfo?.newTopic.toString()
                                    .isNotBlank()
                            ) {
                                if (biliBiliDynamic.data.cards[0].display?.topicInfo?.newTopic?.name.toString()
                                        .isNotBlank()
                                ) {
                                    message =
                                        message.plus(biliBiliDynamic.data.cards[0].display?.topicInfo?.newTopic?.name!!)
                                            .plus("\n")
                                }

                                if (biliBiliDynamic.data.cards[0].display?.topicInfo?.newTopic?.link.toString()
                                        .isNotBlank()
                                ) {
                                    message =
                                        message.plus(biliBiliDynamic.data.cards[0].display?.topicInfo?.newTopic?.link!!)
                                            .plus("\n")
                                }
                            }

                            if (imageList.isEmpty()) {
                                biliBiliDynamicItem.item?.pictures?.forEach {
                                    val toExternalResource =
                                        it.imgSrc?.let { it1 ->
                                            ImageUtil.getImage(it1).toByteArray().toExternalResource()
                                        }
                                    val imageId: String? = toExternalResource?.uploadAsImage(group)?.imageId
                                    imageId?.let { it1 -> imageList.add(it1) }
                                    toExternalResource?.close()
                                }
                            }

                            imageList.forEach {
                                message = message.plus(Image(it)).plus("\n")
                            }

                            message =
                                message.plus("https://t.bilibili.com/${biliBiliDynamic.data.cards[0].desc?.dynamicIdStr}")

                            group.sendMessage(message)
                        } catch (e: Exception) {
                            logger.error(e)
                        }

                    }
                }
            }

        }
    }

}