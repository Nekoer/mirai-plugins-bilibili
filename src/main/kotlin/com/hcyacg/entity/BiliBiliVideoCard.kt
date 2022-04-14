package com.hcyacg.entity

import com.alibaba.fastjson.annotation.JSONField


data class BiliBiliVideoCard(
    @JSONField(name = "aid")
    val aid: Int?,
    @JSONField(name = "attribute")
    val attribute: Int?,
    @JSONField(name = "cid")
    val cid: Int?,
    @JSONField(name = "copyright")
    val copyright: Int?,
    @JSONField(name = "ctime")
    val ctime: Int?,
    @JSONField(name = "desc")
    val desc: String?,
    @JSONField(name = "dimension")
    val dimension: Dimension?,
    @JSONField(name = "duration")
    val duration: Int?,
    @JSONField(name = "dynamic")
    val `dynamic`: String?,
    @JSONField(name = "first_frame")
    val firstFrame: String?,
    @JSONField(name = "jump_url")
    val jumpUrl: String?,
    @JSONField(name = "mission_id")
    val missionId: Int?,
    @JSONField(name = "owner")
    val owner: Owner?,
    @JSONField(name = "pic")
    val pic: String?,
    @JSONField(name = "player_info")
    val playerInfo: Any?,
    @JSONField(name = "pubdate")
    val pubdate: Int?,
    @JSONField(name = "rights")
    val rights: Rights?,
    @JSONField(name = "short_link")
    val shortLink: String?,
    @JSONField(name = "short_link_v2")
    val shortLinkV2: String?,
    @JSONField(name = "stat")
    val stat: Stat?,
    @JSONField(name = "state")
    val state: Int?,
    @JSONField(name = "tid")
    val tid: Int?,
    @JSONField(name = "title")
    val title: String?,
    @JSONField(name = "tname")
    val tname: String?,
    @JSONField(name = "videos")
    val videos: Int?
)

data class Dimension(
    @JSONField(name = "height")
    val height: Int?,
    @JSONField(name = "rotate")
    val rotate: Int?,
    @JSONField(name = "width")
    val width: Int?
)

data class Owner(
    @JSONField(name = "face")
    val face: String?,
    @JSONField(name = "mid")
    val mid: Int?,
    @JSONField(name = "name")
    val name: String?
)

data class Rights(
    @JSONField(name = "autoplay")
    val autoplay: Int?,
    @JSONField(name = "bp")
    val bp: Int?,
    @JSONField(name = "download")
    val download: Int?,
    @JSONField(name = "elec")
    val elec: Int?,
    @JSONField(name = "hd5")
    val hd5: Int?,
    @JSONField(name = "is_cooperation")
    val isCooperation: Int?,
    @JSONField(name = "movie")
    val movie: Int?,
    @JSONField(name = "no_background")
    val noBackground: Int?,
    @JSONField(name = "no_reprint")
    val noReprint: Int?,
    @JSONField(name = "pay")
    val pay: Int?,
    @JSONField(name = "ugc_pay")
    val ugcPay: Int?,
    @JSONField(name = "ugc_pay_preview")
    val ugcPayPreview: Int?
)

data class Stat(
    @JSONField(name = "aid")
    val aid: Int?,
    @JSONField(name = "coin")
    val coin: Int?,
    @JSONField(name = "danmaku")
    val danmaku: Int?,
    @JSONField(name = "dislike")
    val dislike: Int?,
    @JSONField(name = "favorite")
    val favorite: Int?,
    @JSONField(name = "his_rank")
    val hisRank: Int?,
    @JSONField(name = "like")
    val like: Int?,
    @JSONField(name = "now_rank")
    val nowRank: Int?,
    @JSONField(name = "reply")
    val reply: Int?,
    @JSONField(name = "share")
    val share: Int?,
    @JSONField(name = "view")
    val view: Int?
)