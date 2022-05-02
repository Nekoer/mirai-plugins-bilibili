package com.hcyacg.entity

import kotlinx.serialization.Serializable

import kotlinx.serialization.SerialName


@Serializable
data class BiliBiliTextAndImage(
    @SerialName("item")
    val item: BTIItem? = BTIItem(),
    @SerialName("user")
    val user: BTIUser? = BTIUser()
)

@Serializable
data class BTIItem(
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
    val pictures: List<BTIPicture>? = listOf(),
    @SerialName("pictures_count")
    val picturesCount: Int? = 0,
    @SerialName("reply")
    val reply: Int? = 0,
//    @SerialName("role")
//    val role: List<Any>? = listOf(),
    @SerialName("settings")
    val settings: BTISettings? = BTISettings(),
//    @SerialName("source")
//    val source: List<Any>? = listOf(),
    @SerialName("title")
    val title: String? = "",
    @SerialName("upload_time")
    val uploadTime: Int? = 0
)

@Serializable
data class BTIUser(
    @SerialName("head_url")
    val headUrl: String? = "",
    @SerialName("name")
    val name: String? = "",
    @SerialName("uid")
    val uid: Int? = 0,
    @SerialName("vip")
    val vip: BTIVip? = BTIVip()
)

@Serializable
data class BTIPicture(
    @SerialName("img_height")
    val imgHeight: Int? = 0,
    @SerialName("img_size")
    val imgSize: Double? = 0.0,
    @SerialName("img_src")
    val imgSrc: String? = "",
//    @SerialName("img_tags")
//    val imgTags: Any? = Any(),
    @SerialName("img_width")
    val imgWidth: Int? = 0
)

@Serializable
data class BTISettings(
    @SerialName("copy_forbidden")
    val copyForbidden: String? = ""
)

@Serializable
data class BTIVip(
    @SerialName("avatar_subscript")
    val avatarSubscript: Int? = 0,
    @SerialName("due_date")
    val dueDate: Long? = 0,
    @SerialName("label")
    val label: BTILabel? = BTILabel(),
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
data class BTILabel(
    @SerialName("label_theme")
    val labelTheme: String? = "",
    @SerialName("path")
    val path: String? = "",
    @SerialName("text")
    val text: String? = ""
)