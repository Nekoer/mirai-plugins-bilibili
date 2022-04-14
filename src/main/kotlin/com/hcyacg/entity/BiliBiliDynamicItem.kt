package com.hcyacg.entity

import com.alibaba.fastjson.annotation.JSONField


data class BiliBiliDynamicItem(
    @JSONField(name = "item")
    var item: Item?,
    @JSONField(name = "user")
    val user: BDIUser?
)

data class Item(
    @JSONField(name = "at_control")
    val atControl: String?,
    @JSONField(name = "category")
    val category: String?,
    @JSONField(name = "description")
    val description: String?,
    @JSONField(name = "id")
    val id: Int?,
    @JSONField(name = "is_fav")
    val isFav: Int?,
    @JSONField(name = "pictures")
    val pictures: List<Picture>?,
    @JSONField(name = "pictures_count")
    val picturesCount: Int?,
    @JSONField(name = "reply")
    val reply: Int?,
    @JSONField(name = "role")
    val role: List<Any>?,
    @JSONField(name = "settings")
    val settings: Settings?,
    @JSONField(name = "source")
    val source: List<Any>?,
    @JSONField(name = "title")
    val title: String?,
    @JSONField(name = "upload_time")
    val uploadTime: Int?,
    @JSONField(name = "content")
    val content: String?,
    @JSONField(name = "ctrl")
    val ctrl: String?,
    @JSONField(name = "orig_dy_id")
    val origDyId: Int?,
    @JSONField(name = "pre_dy_id")
    val preDyId: Int?,
    @JSONField(name = "rp_id")
    val rpId: Long?,
    @JSONField(name = "timestamp")
    val timestamp: Int?,
    @JSONField(name = "uid")
    val uid: Int?
)

data class BDIUser(
    @JSONField(name = "face")
    val face: String?,
    @JSONField(name = "head_url")
    val headUrl: String?,
    @JSONField(name = "name")
    val name: String?,
    @JSONField(name = "uid")
    val uid: Int?,
    @JSONField(name = "vip")
    val vip: BDIVip?,
    @JSONField(name = "uname")
    val uname: String?
)

data class Picture(
    @JSONField(name = "img_height")
    val imgHeight: Int?,
    @JSONField(name = "img_size")
    val imgSize: Double?,
    @JSONField(name = "img_src")
    val imgSrc: String?,
    @JSONField(name = "img_width")
    val imgWidth: Int?
)

data class Settings(
    @JSONField(name = "copy_forbidden")
    val copyForbidden: String?
)

data class BDIVip(
    @JSONField(name = "avatar_subscript")
    val avatarSubscript: Int?,
    @JSONField(name = "due_date")
    val dueDate: Long?,
    @JSONField(name = "label")
    val label: BDILabel?,
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

data class BDILabel(
    @JSONField(name = "label_theme")
    val labelTheme: String?,
    @JSONField(name = "path")
    val path: String?,
    @JSONField(name = "text")
    val text: String?
)