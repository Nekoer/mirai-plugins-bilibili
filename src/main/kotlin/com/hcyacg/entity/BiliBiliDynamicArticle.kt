package com.hcyacg.entity

import com.alibaba.fastjson.annotation.JSONField


data class BiliBiliDynamicArticle(
    @JSONField(name = "act_id")
    val actId: Int,
    @JSONField(name = "apply_time")
    val applyTime: String,
    @JSONField(name = "authenMark")
    val authenMark: Any,
    @JSONField(name = "author")
    val author: BDAAuthor,
    @JSONField(name = "banner_url")
    val bannerUrl: String,
    @JSONField(name = "categories")
    val categories: List<BDACategory>,
    @JSONField(name = "category")
    val category: BDACategoryX,
    @JSONField(name = "check_time")
    val checkTime: String,
    @JSONField(name = "cover_avid")
    val coverAvid: Int,
    @JSONField(name = "ctime")
    val ctime: Int,
    @JSONField(name = "dispute")
    val dispute: Dispute,
    @JSONField(name = "id")
    val id: Int,
    @JSONField(name = "image_urls")
    val imageUrls: List<String>,
    @JSONField(name = "is_like")
    val isLike: Boolean,
    @JSONField(name = "list")
    val list: BDAList,
    @JSONField(name = "media")
    val media: BDAMedia,
    @JSONField(name = "origin_image_urls")
    val originImageUrls: List<String>,
    @JSONField(name = "original")
    val original: Int,
    @JSONField(name = "publish_time")
    val publishTime: Int,
    @JSONField(name = "reprint")
    val reprint: Int,
    @JSONField(name = "state")
    val state: Int,
    @JSONField(name = "stats")
    val stats: BDAStats,
    @JSONField(name = "summary")
    val summary: String,
    @JSONField(name = "template_id")
    val templateId: Int,
    @JSONField(name = "title")
    val title: String,
    @JSONField(name = "top_video_info")
    val topVideoInfo: Any,
    @JSONField(name = "type")
    val type: Int,
    @JSONField(name = "words")
    val words: Int
)

data class BDAAuthor(
    @JSONField(name = "face")
    val face: String,
    @JSONField(name = "mid")
    val mid: Int,
    @JSONField(name = "name")
    val name: String,
    @JSONField(name = "nameplate")
    val nameplate: BDANameplate,
    @JSONField(name = "official_verify")
    val officialVerify: BDAOfficialVerify,
    @JSONField(name = "pendant")
    val pendant: BDAPendant,
    @JSONField(name = "vip")
    val vip: BDAVip
)

data class BDACategory(
    @JSONField(name = "id")
    val id: Int,
    @JSONField(name = "name")
    val name: String,
    @JSONField(name = "parent_id")
    val parentId: Int
)

data class BDACategoryX(
    @JSONField(name = "id")
    val id: Int,
    @JSONField(name = "name")
    val name: String,
    @JSONField(name = "parent_id")
    val parentId: Int
)

data class Dispute(
    @JSONField(name = "dispute")
    val dispute: String,
    @JSONField(name = "dispute_url")
    val disputeUrl: String
)

data class BDAList(
    @JSONField(name = "apply_time")
    val applyTime: String,
    @JSONField(name = "articles_count")
    val articlesCount: Int,
    @JSONField(name = "check_time")
    val checkTime: String,
    @JSONField(name = "ctime")
    val ctime: Int,
    @JSONField(name = "id")
    val id: Int,
    @JSONField(name = "image_url")
    val imageUrl: String,
    @JSONField(name = "mid")
    val mid: Int,
    @JSONField(name = "name")
    val name: String,
    @JSONField(name = "publish_time")
    val publishTime: Int,
    @JSONField(name = "read")
    val read: Int,
    @JSONField(name = "reason")
    val reason: String,
    @JSONField(name = "state")
    val state: Int,
    @JSONField(name = "summary")
    val summary: String,
    @JSONField(name = "update_time")
    val updateTime: Int,
    @JSONField(name = "words")
    val words: Int
)

data class BDAMedia(
    @JSONField(name = "area")
    val area: String,
    @JSONField(name = "cover")
    val cover: String,
    @JSONField(name = "media_id")
    val mediaId: Int,
    @JSONField(name = "score")
    val score: Int,
    @JSONField(name = "season_id")
    val seasonId: Int,
    @JSONField(name = "spoiler")
    val spoiler: Int,
    @JSONField(name = "title")
    val title: String,
    @JSONField(name = "type_id")
    val typeId: Int,
    @JSONField(name = "type_name")
    val typeName: String
)

data class BDAStats(
    @JSONField(name = "coin")
    val coin: Int,
    @JSONField(name = "dislike")
    val dislike: Int,
    @JSONField(name = "dynamic")
    val `dynamic`: Int,
    @JSONField(name = "favorite")
    val favorite: Int,
    @JSONField(name = "like")
    val like: Int,
    @JSONField(name = "reply")
    val reply: Int,
    @JSONField(name = "share")
    val share: Int,
    @JSONField(name = "view")
    val view: Int
)

data class BDANameplate(
    @JSONField(name = "condition")
    val condition: String,
    @JSONField(name = "image")
    val image: String,
    @JSONField(name = "image_small")
    val imageSmall: String,
    @JSONField(name = "level")
    val level: String,
    @JSONField(name = "name")
    val name: String,
    @JSONField(name = "nid")
    val nid: Int
)

data class BDAOfficialVerify(
    @JSONField(name = "desc")
    val desc: String,
    @JSONField(name = "type")
    val type: Int
)

data class BDAPendant(
    @JSONField(name = "expire")
    val expire: Int,
    @JSONField(name = "image")
    val image: String,
    @JSONField(name = "name")
    val name: String,
    @JSONField(name = "pid")
    val pid: Int
)

data class BDAVip(
    @JSONField(name = "avatar_subscript")
    val avatarSubscript: Int,
    @JSONField(name = "due_date")
    val dueDate: Int,
    @JSONField(name = "label")
    val label: BDALabel,
    @JSONField(name = "nickname_color")
    val nicknameColor: String,
    @JSONField(name = "status")
    val status: Int,
    @JSONField(name = "theme_type")
    val themeType: Int,
    @JSONField(name = "type")
    val type: Int,
    @JSONField(name = "vip_pay_type")
    val vipPayType: Int
)

data class BDALabel(
    @JSONField(name = "label_theme")
    val labelTheme: String,
    @JSONField(name = "path")
    val path: String,
    @JSONField(name = "text")
    val text: String
)