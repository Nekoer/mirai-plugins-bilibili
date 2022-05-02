package com.hcyacg.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BiliBiliDynamicArticle(
    @SerialName("act_id")
    val actId: Int? = 0,
    @SerialName("apply_time")
    val applyTime: String? = "",
//    @SerialName("authenMark")
//    val authenMark: Any,
    @SerialName("author")
    val author: BDAAuthor? = BDAAuthor(),
    @SerialName("banner_url")
    val bannerUrl: String? = "",
    @SerialName("categories")
    val categories: List<BDACategory>? = listOf(),
    @SerialName("category")
    val category: BDACategoryX? = BDACategoryX(),
    @SerialName("check_time")
    val checkTime: String? = "",
    @SerialName("cover_avid")
    val coverAvid: Int? = 0,
    @SerialName("ctime")
    val ctime: Int? = 0,
    @SerialName("dispute")
    val dispute: Dispute? = Dispute(),
    @SerialName("id")
    val id: Int? = 0,
    @SerialName("image_urls")
    val imageUrls: List<String> = listOf(),
    @SerialName("is_like")
    val isLike: Boolean? = false,
    @SerialName("list")
    val list: BDAList? = BDAList(),
    @SerialName("media")
    val media: BDAMedia? = BDAMedia(),
    @SerialName("origin_image_urls")
    val originImageUrls: List<String> = listOf(),
    @SerialName("original")
    val original: Int? = 0,
    @SerialName("publish_time")
    val publishTime: Int? = 0,
    @SerialName("reprInt")
    val reprInt: Int? = 0,
    @SerialName("state")
    val state: Int? = 0,
    @SerialName("stats")
    val stats: BDAStats? = BDAStats(),
    @SerialName("summary")
    val summary: String? = "",
    @SerialName("template_id")
    val templateId: Int? = 0,
    @SerialName("title")
    val title: String? = "",
//    @SerialName("top_video_info")
//    val topVideoInfo: Any,
    @SerialName("type")
    val type: Int? = 0,
    @SerialName("words")
    val words: Int? = 0
)

@Serializable
data class BDAAuthor(
    @SerialName("face")
    val face: String? = "",
    @SerialName("mid")
    val mid: Int? = 0,
    @SerialName("name")
    val name: String? = "",
    @SerialName("nameplate")
    val nameplate: BDANameplate? = BDANameplate(),
    @SerialName("official_verify")
    val officialVerify: BDAOfficialVerify? = BDAOfficialVerify(),
    @SerialName("pendant")
    val pendant: BDAPendant? = BDAPendant(),
    @SerialName("vip")
    val vip: BDAVip? = BDAVip()
)

@Serializable
data class BDACategory(
    @SerialName("id")
    val id: Int? = 0,
    @SerialName("name")
    val name: String? = "",
    @SerialName("parent_id")
    val parentId: Int? = 0
)

@Serializable
data class BDACategoryX(
    @SerialName("id")
    val id: Int? = 0,
    @SerialName("name")
    val name: String? = "",
    @SerialName("parent_id")
    val parentId: Int? = 0
)

@Serializable
data class Dispute(
    @SerialName("dispute")
    val dispute: String? = "",
    @SerialName("dispute_url")
    val disputeUrl: String? = ""
)

@Serializable
data class BDAList(
    @SerialName("apply_time")
    val applyTime: String? = "",
    @SerialName("articles_count")
    val articlesCount: Int? = 0,
    @SerialName("check_time")
    val checkTime: String? = "",
    @SerialName("ctime")
    val ctime: Int? = 0,
    @SerialName("id")
    val id: Int? = 0,
    @SerialName("image_url")
    val imageUrl: String? = "",
    @SerialName("mid")
    val mid: Int? = 0,
    @SerialName("name")
    val name: String? = "",
    @SerialName("publish_time")
    val publishTime: Int? = 0,
    @SerialName("read")
    val read: Int? = 0,
    @SerialName("reason")
    val reason: String? = "",
    @SerialName("state")
    val state: Int? = 0,
    @SerialName("summary")
    val summary: String? = "",
    @SerialName("update_time")
    val updateTime: Int? = 0,
    @SerialName("words")
    val words: Int? = 0
)

@Serializable
data class BDAMedia(
    @SerialName("area")
    val area: String? = "",
    @SerialName("cover")
    val cover: String? = "",
    @SerialName("media_id")
    val mediaId: Int? = 0,
    @SerialName("score")
    val score: Int? = 0,
    @SerialName("season_id")
    val seasonId: Int? = 0,
    @SerialName("spoiler")
    val spoiler: Int? = 0,
    @SerialName("title")
    val title: String? = "",
    @SerialName("type_id")
    val typeId: Int? = 0,
    @SerialName("type_name")
    val typeName: String? = ""
)

@Serializable
data class BDAStats(
    @SerialName("coin")
    val coin: Int? = 0,
    @SerialName("dislike")
    val dislike: Int? = 0,
    @SerialName("dynamic")
    val `dynamic`: Int? = 0,
    @SerialName("favorite")
    val favorite: Int? = 0,
    @SerialName("like")
    val like: Int? = 0,
    @SerialName("reply")
    val reply: Int? = 0,
    @SerialName("share")
    val share: Int? = 0,
    @SerialName("view")
    val view: Int? = 0
)

@Serializable
data class BDANameplate(
    @SerialName("condition")
    val condition: String? = "",
    @SerialName("image")
    val image: String? = "",
    @SerialName("image_small")
    val imageSmall: String? = "",
    @SerialName("level")
    val level: String? = "",
    @SerialName("name")
    val name: String? = "",
    @SerialName("nid")
    val nid: Int? = 0
)

@Serializable
data class BDAOfficialVerify(
    @SerialName("desc")
    val desc: String? = "",
    @SerialName("type")
    val type: Int? = 0
)

@Serializable
data class BDAPendant(
    @SerialName("expire")
    val expire: Int? = 0,
    @SerialName("image")
    val image: String? = "",
    @SerialName("name")
    val name: String? = "",
    @SerialName("pid")
    val pid: Int? = 0
)

@Serializable
data class BDAVip(
    @SerialName("avatar_subscript")
    val avatarSubscript: Int? = 0,
    @SerialName("due_date")
    val dueDate: Int? = 0,
    @SerialName("label")
    val label: BDALabel? = BDALabel(),
    @SerialName("nickname_color")
    val nicknameColor: String? = "",
    @SerialName("status")
    val status: Int? = 0,
    @SerialName("theme_type")
    val themeType: Int? = 0,
    @SerialName("type")
    val type: Int? = 0,
    @SerialName("vip_pay_type")
    val vipPayType: Int? = 0
)

@Serializable
data class BDALabel(
    @SerialName("label_theme")
    val labelTheme: String? = "",
    @SerialName("path")
    val path: String? = "",
    @SerialName("text")
    val text: String? = ""
)