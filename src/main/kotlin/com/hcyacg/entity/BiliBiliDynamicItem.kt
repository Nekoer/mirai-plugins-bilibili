package com.hcyacg.entity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BiliBiliDynamicItem(
    @SerialName("item")
    var item: Item? = Item(),
    @SerialName("user")
    val user: BDIUser? = BDIUser()
)

@Serializable
data class Item(
    @SerialName("at_control")
    val atControl: String? = "",
    @SerialName("category")
    val category: String? = "",
    @SerialName("description")
    val description: String? = "",
    @SerialName("id")
    val id: Int? = 0,
    @SerialName("is_fav")
    val isFav: Int? = 0,
    @SerialName("pictures")
    val pictures: List<Picture>? = listOf(),
    @SerialName("pictures_count")
    val picturesCount: Int? = 0,
    @SerialName("reply")
    val reply: Int? = 0,
//    @SerialName("role")
//    val role: List<Any>?,
    @SerialName("settings")
    val settings: Settings? = Settings(),
//    @SerialName("source")
//    val source: List<Any>?,
    @SerialName("title")
    val title: String? = "",
    @SerialName("upload_time")
    val uploadTime: Int? = 0,
    @SerialName("content")
    val content: String? = "",
    @SerialName("ctrl")
    val ctrl: String? = "",
    @SerialName("orig_dy_id")
    val origDyId: Int? = 0,
    @SerialName("pre_dy_id")
    val preDyId: Int? = 0,
    @SerialName("rp_id")
    val rpId: Long? = 0,
    @SerialName("timestamp")
    val timestamp: Int? = 0,
    @SerialName("uid")
    val uid: Int? = 0
)

@Serializable
data class BDIUser(
    @SerialName("face")
    val face: String? = "",
    @SerialName("head_url")
    val headUrl: String? = "",
    @SerialName("name")
    val name: String? = "",
    @SerialName("uid")
    val uid: Int? = 0,
    @SerialName("vip")
    val vip: BDIVip? = BDIVip(),
    @SerialName("uname")
    val uname: String? = ""
)

@Serializable
data class Picture(
    @SerialName("img_height")
    val imgHeight: Int? = 0,
    @SerialName("img_size")
    val imgSize: Double? = 0.0,
    @SerialName("img_src")
    val imgSrc: String? = "",
    @SerialName("img_width")
    val imgWidth: Int? = 0
)

@Serializable
data class Settings(
    @SerialName("copy_forbidden")
    val copyForbidden: String? = ""
)

@Serializable
data class BDIVip(
    @SerialName("avatar_subscript")
    val avatarSubscript: Int? = 0,
    @SerialName("due_date")
    val dueDate: Long? = 0,
    @SerialName("label")
    val label: BDILabel? = BDILabel(),
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
data class BDILabel(
    @SerialName("label_theme")
    val labelTheme: String? = "",
    @SerialName("path")
    val path: String? = "",
    @SerialName("text")
    val text: String? = ""
)