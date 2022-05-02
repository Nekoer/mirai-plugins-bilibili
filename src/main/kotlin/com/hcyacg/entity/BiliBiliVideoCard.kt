package com.hcyacg.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BiliBiliVideoCard(
    @SerialName("aid")
    val aid: Int? = 0,
    @SerialName("attribute")
    val attribute: Int? = 0,
    @SerialName("cid")
    val cid: Int? = 0,
    @SerialName("copyright")
    val copyright: Int? = 0,
    @SerialName("ctime")
    val ctime: Int? = 0,
    @SerialName("desc")
    val desc: String? = "",
    @SerialName("dimension")
    val dimension: Dimension? = Dimension(),
    @SerialName("duration")
    val duration: Int? = 0,
    @SerialName("dynamic")
    val `dynamic`: String? = "",
    @SerialName("first_frame")
    val firstFrame: String? = "",
    @SerialName("jump_url")
    val jumpUrl: String? = "",
    @SerialName("mission_id")
    val missionId: Int? = 0,
    @SerialName("owner")
    val owner: Owner? = Owner(),
    @SerialName("pic")
    val pic: String? = "",
//    @SerialName("player_info")
//    val playerInfo: Any?,
    @SerialName("pubdate")
    val pubdate: Int? = 0,
    @SerialName("rights")
    val rights: Rights? = Rights(),
    @SerialName("short_link")
    val shortLink: String? = "",
    @SerialName("short_link_v2")
    val shortLinkV2: String? = "",
    @SerialName("stat")
    val stat: Stat? = Stat(),
    @SerialName("state")
    val state: Int? = 0,
    @SerialName("tid")
    val tid: Int? = 0,
    @SerialName("title")
    val title: String? = "",
    @SerialName("tname")
    val tname: String? = "",
    @SerialName("videos")
    val videos: Int? = 0
)

@Serializable
data class Dimension(
    @SerialName("height")
    val height: Int? = 0,
    @SerialName("rotate")
    val rotate: Int? = 0,
    @SerialName("width")
    val width: Int? = 0
)

@Serializable
data class Owner(
    @SerialName("face")
    val face: String? = "",
    @SerialName("mid")
    val mid: Int? = 0,
    @SerialName("name")
    val name: String? = ""
)

@Serializable
data class Rights(
    @SerialName("autoplay")
    val autoplay: Int? = 0,
    @SerialName("bp")
    val bp: Int? = 0,
    @SerialName("download")
    val download: Int? = 0,
    @SerialName("elec")
    val elec: Int? = 0,
    @SerialName("hd5")
    val hd5: Int? = 0,
    @SerialName("is_cooperation")
    val isCooperation: Int? = 0,
    @SerialName("movie")
    val movie: Int? = 0,
    @SerialName("no_background")
    val noBackground: Int? = 0,
    @SerialName("no_reprint")
    val noReprint: Int? = 0,
    @SerialName("pay")
    val pay: Int? = 0,
    @SerialName("ugc_pay")
    val ugcPay: Int? = 0,
    @SerialName("ugc_pay_preview")
    val ugcPayPreview: Int? = 0
)

@Serializable
data class Stat(
    @SerialName("aid")
    val aid: Int? = 0,
    @SerialName("coin")
    val coin: Int? = 0,
    @SerialName("danmaku")
    val danmaku: Int? = 0,
    @SerialName("dislike")
    val dislike: Int? = 0,
    @SerialName("favorite")
    val favorite: Int? = 0,
    @SerialName("his_rank")
    val hisRank: Int? = 0,
    @SerialName("like")
    val like: Int? = 0,
    @SerialName("now_rank")
    val nowRank: Int? = 0,
    @SerialName("reply")
    val reply: Int? = 0,
    @SerialName("share")
    val share: Int? = 0,
    @SerialName("view")
    val view: Int? = 0
)