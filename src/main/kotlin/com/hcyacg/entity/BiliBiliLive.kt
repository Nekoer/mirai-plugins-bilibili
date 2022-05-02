package com.hcyacg.entity


import kotlinx.serialization.Contextual
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable
data class BiliBiliLive(
    @SerialName("code")
    val code: Int? = 0,
    @SerialName("data")
    val `data`: BLData? = BLData(),
    @SerialName("message")
    val message: String? = "",
    @SerialName("ttl")
    val ttl: Int? = 0
)

@Serializable
data class BLData(
    @SerialName("birthday")
    val birthday: String? = "",
    @SerialName("coins")
    val coins: Double? = 0.0,
    @SerialName("face")
    val face: String? = "",
    @SerialName("face_nft")
    val faceNft: Int? = 0,
    @SerialName("fans_badge")
    val fansBadge: Boolean? = false,
    @SerialName("fans_medal")
    val fansMedal: FansMedal? = FansMedal(),
    @SerialName("is_followed")
    val isFollowed: Boolean? = false,
    @SerialName("is_senior_member")
    val isSeniorMember: Int? = 0,
    @SerialName("jointime")
    val jointime: Int? = 0,
    @SerialName("level")
    val level: Int? = 0,
    @SerialName("live_room")
    val liveRoom: LiveRoom? = LiveRoom(),
    @SerialName("mid")
    val mid: Int? = 0,
    @SerialName("moral")
    val moral: Int? = 0,
    @SerialName("name")
    val name: String? = "",
    @SerialName("nameplate")
    val nameplate: BLNameplate? = BLNameplate(),
    @SerialName("official")
    val official: Official? = Official(),
    @SerialName("pendant")
    val pendant: BLPendant? = BLPendant(),
    @SerialName("profession")
    val profession: Profession? = Profession(),
    @SerialName("rank")
    val rank: Int? = 0,
    @SerialName("school")
    val school: School? = School(),
    @SerialName("series")
    val series: Series? = Series(),
    @SerialName("sex")
    val sex: String? = "",
    @SerialName("sign")
    val sign: String? = "",
    @SerialName("silence")
    val silence: Int? = 0,
    @SerialName("sys_notice")
    val sysNotice: SysNotice? = SysNotice(),
//    @SerialName("tags")
//    val tags: Any? = Any(),
    @SerialName("theme")
    val theme: Theme? = Theme(),
    @SerialName("top_photo")
    val topPhoto: String? = "",
    @SerialName("user_honour_info")
    val userHonourInfo: UserHonourInfo? = UserHonourInfo(),
    @SerialName("vip")
    val vip: BLVip? = BLVip()
)

@Serializable
data class FansMedal(
    @SerialName("medal")
    val medal: Medal? = Medal(),
    @SerialName("show")
    val show: Boolean? = false,
    @SerialName("wear")
    val wear: Boolean? = false
)

@Serializable
data class LiveRoom(
    @SerialName("broadcast_type")
    val broadcastType: Int? = 0,
    @SerialName("cover")
    val cover: String? = "",
    @SerialName("liveStatus")
    val liveStatus: Int? = 0, // 0 未开播 1 开播中 2 轮播中
    @SerialName("roomStatus")
    val roomStatus: Int? = 0,
    @SerialName("roomid")
    val roomid: Int? = 0,
    @SerialName("roundStatus")
    val roundStatus: Int? = 0,
    @SerialName("title")
    val title: String? = "",
    @SerialName("url")
    val url: String? = "",
    @SerialName("watched_show")
    val watchedShow: WatchedShow? = WatchedShow()
)

@Serializable
data class BLNameplate(
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
data class Official(
    @SerialName("desc")
    val desc: String? = "",
    @SerialName("role")
    val role: Int? = 0,
    @SerialName("title")
    val title: String? = "",
    @SerialName("type")
    val type: Int? = 0
)

@Serializable
data class BLPendant(
    @SerialName("expire")
    val expire: Int? = 0,
    @SerialName("image")
    val image: String? = "",
    @SerialName("image_enhance")
    val imageEnhance: String? = "",
    @SerialName("image_enhance_frame")
    val imageEnhanceFrame: String? = "",
    @SerialName("name")
    val name: String? = "",
    @SerialName("pid")
    val pid: Int? = 0
)

@Serializable
data class Profession(
    @SerialName("department")
    val department: String? = "",
    @SerialName("is_show")
    val isShow: Int? = 0,
    @SerialName("name")
    val name: String? = "",
    @SerialName("title")
    val title: String? = ""
)

@Serializable
data class School(
    @SerialName("name")
    val name: String? = ""
)

@Serializable
data class Series(
    @SerialName("show_upgrade_window")
    val showUpgradeWindow: Boolean? = false,
    @SerialName("user_upgrade_status")
    val userUpgradeStatus: Int? = 0
)

@Serializable
class SysNotice

@Serializable
class Theme

@Serializable
data class UserHonourInfo(
//    @SerialName("colour")
//    val colour: Any = Any(),
    @SerialName("mid")
    val mid: Int? = 0,
//    @SerialName("tags")
//    val tags: List<Any>? = listOf()
)

@Serializable
data class BLVip(
    @SerialName("avatar_subscript")
    val avatarSubscript: Int? = 0,
    @SerialName("avatar_subscript_url")
    val avatarSubscriptUrl: String? = "",
    @SerialName("due_date")
    val dueDate: Long? = 0,
    @SerialName("label")
    val label: BLLabel? = BLLabel(),
    @SerialName("nickname_color")
    val nicknameColor: String? = "",
    @SerialName("role")
    val role: Int? = 0,
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
data class Medal(
    @SerialName("day_limit")
    val dayLimit: Int? = 0,
    @SerialName("intimacy")
    val intimacy: Int? = 0,
    @SerialName("is_lighted")
    val isLighted: Int? = 0,
    @SerialName("level")
    val level: Int? = 0,
    @SerialName("light_status")
    val lightStatus: Int? = 0,
    @SerialName("medal_color")
    val medalColor: Int? = 0,
    @SerialName("medal_color_border")
    val medalColorBorder: Int? = 0,
    @SerialName("medal_color_end")
    val medalColorEnd: Int? = 0,
    @SerialName("medal_color_start")
    val medalColorStart: Int? = 0,
    @SerialName("medal_id")
    val medalId: Int? = 0,
    @SerialName("medal_name")
    val medalName: String? = "",
    @SerialName("next_intimacy")
    val nextIntimacy: Int? = 0,
    @SerialName("score")
    val score: Int? = 0,
    @SerialName("target_id")
    val targetId: Int? = 0,
    @SerialName("uid")
    val uid: Int? = 0,
    @SerialName("wearing_status")
    val wearingStatus: Int? = 0
)

@Serializable
data class WatchedShow(
    @SerialName("icon")
    val icon: String? = "",
    @SerialName("icon_location")
    val iconLocation: String? = "",
    @SerialName("icon_web")
    val iconWeb: String? = "",
    @SerialName("num")
    val num: Int? = 0,
    @SerialName("switch")
    val switch: Boolean? = false,
    @SerialName("text_large")
    val textLarge: String? = "",
    @SerialName("text_small")
    val textSmall: String? = ""
)

@Serializable
data class BLLabel(
    @SerialName("bg_color")
    val bgColor: String? = "",
    @SerialName("bg_style")
    val bgStyle: Int? = 0,
    @SerialName("border_color")
    val borderColor: String? = "",
    @SerialName("label_theme")
    val labelTheme: String? = "",
    @SerialName("path")
    val path: String? = "",
    @SerialName("text")
    val text: String? = "",
    @SerialName("text_color")
    val textColor: String? = ""
)