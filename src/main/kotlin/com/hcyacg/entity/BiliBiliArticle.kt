package com.hcyacg.entity

import com.alibaba.fastjson.annotation.JSONField


data class BiliBiliArticle(
    @JSONField(name = "code")
    val code: Int,
    @JSONField(name = "data")
    val data: BAData,
    @JSONField(name = "message")
    val message: String,
    @JSONField(name = "ttl")
    val ttl: Int
)

data class BAData(
    @JSONField(name = "articles")
    val articles: List<Article>?,
    @JSONField(name = "count")
    val count: Int,
    @JSONField(name = "pn")
    val pn: Int,
    @JSONField(name = "ps")
    val ps: Int
)

data class Article(
    @JSONField(name = "act_id")
    val actId: Int?,
    @JSONField(name = "apply_time")
    val applyTime: String?,
    @JSONField(name = "attributes")
    val attributes: Int?,
    @JSONField(name = "authenMark")
    val authenMark: Any?,
    @JSONField(name = "author")
    val author: Author?,
    @JSONField(name = "banner_url")
    val bannerUrl: String?,
    @JSONField(name = "categories")
    val categories: List<Category>?,
    @JSONField(name = "category")
    val category: CategoryX?,
    @JSONField(name = "check_time")
    val checkTime: String?,
    @JSONField(name = "cover_avid")
    val coverAvid: Int?,
    @JSONField(name = "ctime")
    val ctime: Long?,
    @JSONField(name = "dispute")
    val dispute: Any?,
    @JSONField(name = "id")
    val id: Int?,
    @JSONField(name = "image_urls")
    val imageUrls: List<String>?,
    @JSONField(name = "is_like")
    val isLike: Boolean?,
    @JSONField(name = "list")
    val list: Any?,
    @JSONField(name = "media")
    val media: Media?,
    @JSONField(name = "origin_image_urls")
    val originImageUrls: List<String>?,
    @JSONField(name = "original")
    val original: Int?,
    @JSONField(name = "publish_time")
    val publishTime: Int?,
    @JSONField(name = "reprint")
    val reprint: Int?,
    @JSONField(name = "state")
    val state: Int?,
    @JSONField(name = "stats")
    val stats: Stats?,
    @JSONField(name = "summary")
    val summary: String?,
    @JSONField(name = "template_id")
    val templateId: Int?,
    @JSONField(name = "title")
    val title: String?,
    @JSONField(name = "top_video_info")
    val topVideoInfo: Any?,
    @JSONField(name = "type")
    val type: Int?,
    @JSONField(name = "words")
    val words: Int?
)

data class Author(
    @JSONField(name = "face")
    val face: String?,
    @JSONField(name = "mid")
    val mid: Int?,
    @JSONField(name = "name")
    val name: String?,
    @JSONField(name = "nameplate")
    val nameplate: Nameplate?,
    @JSONField(name = "official_verify")
    val officialVerify: OfficialVerify?,
    @JSONField(name = "pendant")
    val pendant: Pendant?,
    @JSONField(name = "vip")
    val vip: Vip?
)

data class Category(
    @JSONField(name = "id")
    val id: Int?,
    @JSONField(name = "name")
    val name: String?,
    @JSONField(name = "parent_id")
    val parentId: Int?
)

data class CategoryX(
    @JSONField(name = "id")
    val id: Int?,
    @JSONField(name = "name")
    val name: String?,
    @JSONField(name = "parent_id")
    val parentId: Int?
)

data class Media(
    @JSONField(name = "area")
    val area: String?,
    @JSONField(name = "cover")
    val cover: String?,
    @JSONField(name = "media_id")
    val mediaId: Int?,
    @JSONField(name = "score")
    val score: Int?,
    @JSONField(name = "spoiler")
    val spoiler: Int?,
    @JSONField(name = "title")
    val title: String?,
    @JSONField(name = "type_id")
    val typeId: Int?,
    @JSONField(name = "type_name")
    val typeName: String?
)

data class Stats(
    @JSONField(name = "coin")
    val coin: Int?,
    @JSONField(name = "dislike")
    val dislike: Int?,
    @JSONField(name = "dynamic")
    val `dynamic`: Int?,
    @JSONField(name = "favorite")
    val favorite: Int?,
    @JSONField(name = "like")
    val like: Int?,
    @JSONField(name = "reply")
    val reply: Int?,
    @JSONField(name = "share")
    val share: Int?,
    @JSONField(name = "view")
    val view: Int?
)

data class Nameplate(
    @JSONField(name = "condition")
    val condition: String?,
    @JSONField(name = "image")
    val image: String?,
    @JSONField(name = "image_small")
    val imageSmall: String?,
    @JSONField(name = "level")
    val level: String?,
    @JSONField(name = "name")
    val name: String?,
    @JSONField(name = "nid")
    val nid: Int?
)

data class OfficialVerify(
    @JSONField(name = "desc")
    val desc: String?,
    @JSONField(name = "type")
    val type: Int?
)

data class Pendant(
    @JSONField(name = "expire")
    val expire: Int?,
    @JSONField(name = "image")
    val image: String?,
    @JSONField(name = "name")
    val name: String?,
    @JSONField(name = "pid")
    val pid: Int?
)

data class Vip(
    @JSONField(name = "avatar_subscript")
    val avatarSubscript: Int?,
    @JSONField(name = "due_date")
    val dueDate: Int?,
    @JSONField(name = "label")
    val label: Label?,
    @JSONField(name = "nickname_color")
    val nicknameColor: String?,
    @JSONField(name = "status")
    val status: Int?,
    @JSONField(name = "theme_type")
    val themeType: Int?,
    @JSONField(name = "type")
    val type: Int?,
    @JSONField(name = "vip_pay_type")
    val vipPayType: Int?
)

data class Label(
    @JSONField(name = "label_theme")
    val labelTheme: String?,
    @JSONField(name = "path")
    val path: String?,
    @JSONField(name = "text")
    val text: String?
)