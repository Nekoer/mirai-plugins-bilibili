package com.hcyacg.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BiliBiliArticle(
    @SerialName("code")
    val code: Int? = 0,
    @SerialName("data")
    val data: BAData? = BAData(),
    @SerialName("message")
    val message: String? = "",
    @SerialName("ttl")
    val ttl: Int? = 0
)

@Serializable
data class BAData(
    @SerialName("articles")
    val articles: List<Article>? = listOf(),
    @SerialName("count")
    val count: Int? = 0,
    @SerialName("pn")
    val pn: Int? = 0,
    @SerialName("ps")
    val ps: Int? = 0
)

@Serializable
data class Article(
    @SerialName("act_id")
    val actId: Int? = 0,
    @SerialName("apply_time")
    val applyTime: String? = "",
    @SerialName("attributes")
    val attributes: Int? = 0,
//    @SerialName("authenMark")
//    val authenMark: Any?,
    @SerialName("author")
    val author: Author? = Author(),
    @SerialName("banner_url")
    val bannerUrl: String? = "",
    @SerialName("categories")
    val categories: List<Category>? = listOf(),
    @SerialName("category")
    val category: CategoryX? = CategoryX(),
    @SerialName("check_time")
    val checkTime: String? = "",
    @SerialName("cover_avid")
    val coverAvid: Int? = 0,
    @SerialName("ctime")
    val ctime: Long? = 0,
//    @SerialName("dispute")
//    val dispute: Any?,
    @SerialName("id")
    val id: Int? = 0,
    @SerialName("image_urls")
    val imageUrls: List<String>?,
    @SerialName("is_like")
    val isLike: Boolean? = false,
//    @SerialName("list")
//    val list: Any?,
    @SerialName("media")
    val media: Media? = Media(),
    @SerialName("origin_image_urls")
    val originImageUrls: List<String>? = listOf(),
    @SerialName("original")
    val original: Int? = 0,
    @SerialName("publish_time")
    val publishTime: Int? = 0,
    @SerialName("reprint")
    val reprint: Int? = 0,
    @SerialName("state")
    val state: Int? = 0,
    @SerialName("stats")
    val stats: Stats? = Stats(),
    @SerialName("summary")
    val summary: String? = "",
    @SerialName("template_id")
    val templateId: Int? = 0,
    @SerialName("title")
    val title: String? = "",
//    @SerialName("top_video_info")
//    val topVideoInfo: Any?,
    @SerialName("type")
    val type: Int? = 0,
    @SerialName("words")
    val words: Int? = 0
)

@Serializable
data class Author(
    @SerialName("face")
    val face: String? = "",
    @SerialName("mid")
    val mid: Int? = 0,
    @SerialName("name")
    val name: String? = "",
    @SerialName("nameplate")
    val nameplate: Nameplate? = Nameplate(),
    @SerialName("official_verify")
    val officialVerify: BDOfficialVerify? = BDOfficialVerify(),
    @SerialName("pendant")
    val pendant: BDPendant? = BDPendant(),
    @SerialName("vip")
    val vip: BDVip? = BDVip()
)

@Serializable
data class Category(
    @SerialName("id")
    val id: Int? = 0,
    @SerialName("name")
    val name: String? = "",
    @SerialName("parent_id")
    val parentId: Int? = 0
)

@Serializable
data class CategoryX(
    @SerialName("id")
    val id: Int? = 0,
    @SerialName("name")
    val name: String? = "",
    @SerialName("parent_id")
    val parentId: Int? = 0
)

@Serializable
data class Media(
    @SerialName("area")
    val area: String? = "",
    @SerialName("cover")
    val cover: String? = "",
    @SerialName("media_id")
    val mediaId: Int? = 0,
    @SerialName("score")
    val score: Int? = 0,
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
data class Stats(
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
data class Nameplate(
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
data class BDOfficialVerify(
    @SerialName("desc")
    val desc: String? = "",
    @SerialName("type")
    val type: Int? = 0
)

@Serializable
data class BDPendant(
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
data class BDVip(
    @SerialName("avatar_subscript")
    val avatarSubscript: Int? = 0,
    @SerialName("due_date")
    val dueDate: Int? = 0,
    @SerialName("label")
    val label: BDLabel? = BDLabel(),
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
data class BDLabel(
    @SerialName("label_theme")
    val labelTheme: String? = "",
    @SerialName("path")
    val path: String? = "",
    @SerialName("text")
    val text: String? = ""
)