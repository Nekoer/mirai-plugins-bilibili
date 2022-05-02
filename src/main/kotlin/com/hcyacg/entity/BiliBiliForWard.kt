package com.hcyacg.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BiliBiliForWard(
    @SerialName("item")
    val item: BFWItem? = BFWItem(),
    @SerialName("origin")
    val origin: String? = "",
    @SerialName("origin_extend_json")
    val originExtendJson: String? = "",
    @SerialName("origin_user")
    val originUser: OriginUser? = OriginUser(),
    @SerialName("user")
    val user: UserX? = UserX()
)

@Serializable
data class BFWItem(
    @SerialName("content")
    val content: String? = "",
    @SerialName("ctrl")
    val ctrl: String? = "",
    @SerialName("orig_dy_id")
    val origDyId: Long? = 0,
    @SerialName("orig_type")
    val origType: Int? = 0,
    @SerialName("pre_dy_id")
    val preDyId: Long? = 0,
    @SerialName("reply")
    val reply: Int? = 0,
    @SerialName("rp_id")
    val rpId: Long? = 0,
    @SerialName("timestamp")
    val timestamp: Int? = 0,
    @SerialName("uid")
    val uid: Int? = 0
)

@Serializable
data class OriginUser(
    @SerialName("card")
    val card: BFWCard? = BFWCard(),
    @SerialName("info")
    val info: BFWInfo? = BFWInfo(),
    @SerialName("level_info")
    val levelInfo: BFWLevelInfo? = BFWLevelInfo(),
    @SerialName("pendant")
    val pendant: BFWPendant? = BFWPendant(),
    @SerialName("rank")
    val rank: String? = "",
    @SerialName("sign")
    val sign: String? = "",
    @SerialName("vip")
    val vip: VipX? = VipX()
)

@Serializable
data class UserX(
    @SerialName("face")
    val face: String? = "",
    @SerialName("uid")
    val uid: Int? = 0,
    @SerialName("uname")
    val uname: String? = ""
)

@Serializable
data class BFWLabel(
    @SerialName("label_theme")
    val labelTheme: String? = "",
    @SerialName("path")
    val path: String? = "",
    @SerialName("text")
    val text: String? = ""
)

@Serializable
data class Verify(
    @SerialName("asw")
    val asw: Asw? = Asw(),
    @SerialName("cc")
    val cc: Cc? = Cc(),
    @SerialName("csw")
    val csw: Csw? = Csw(),
    @SerialName("dc")
    val dc: Dc? = Dc(),
    @SerialName("gc")
    val gc: Gc? = Gc(),
    @SerialName("ra")
    val ra: Ra? = Ra(),
    @SerialName("sp")
    val sp: Sp? = Sp(),
    @SerialName("sw")
    val sw: Sw? = Sw(),
    @SerialName("ur")
    val ur: Ur? = Ur()
)

@Serializable
data class Asw(
    @SerialName("fl")
    val fl: Int? = 0,
    @SerialName("nv")
    val nv: Int? = 0
)

@Serializable
class Cc

@Serializable
class Csw

@Serializable
class Dc

@Serializable
class Gc

@Serializable
class Ra

@Serializable
class Sp

@Serializable
data class Sw(
    @SerialName("fl")
    val fl: Int? = 0,
    @SerialName("nv")
    val nv: Int? = 0
)

@Serializable
class Ur

@Serializable
data class BFWCard(
    @SerialName("official_verify")
    val officialVerify: BFWOfficialVerify? = BFWOfficialVerify()
)

@Serializable
data class BFWInfo(
    @SerialName("face")
    val face: String? = "",
    @SerialName("face_nft")
    val faceNft: Int? = 0,
    @SerialName("uid")
    val uid: Int? = 0,
    @SerialName("uname")
    val uname: String? = ""
)

@Serializable
data class BFWLevelInfo(
    @SerialName("current_level")
    val currentLevel: Int? = 0
)

@Serializable
data class BFWPendant(
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
data class VipX(
    @SerialName("avatar_subscript")
    val avatarSubscript: Int? = 0,
    @SerialName("avatar_subscript_url")
    val avatarSubscriptUrl: String? = "",
    @SerialName("label")
    val label: LabelX? = LabelX(),
    @SerialName("nickname_color")
    val nicknameColor: String? = "",
    @SerialName("role")
    val role: Int? = 0,
    @SerialName("themeType")
    val themeType: Int? = 0,
    @SerialName("vipDueDate")
    val vipDueDate: Long? = 0,
    @SerialName("vipStatus")
    val vipStatus: Int? = 0,
    @SerialName("vipType")
    val vipType: Int? = 0
)

@Serializable
data class BFWOfficialVerify(
    @SerialName("desc")
    val desc: String? = "",
    @SerialName("type")
    val type: Int? = 0
)

@Serializable
data class LabelX(
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

@Serializable
data class OriginJson(
    @SerialName("item")
    val item: OItem? = OItem(),
    @SerialName("user")
    val user: OUser? = OUser()
)

@Serializable
data class OItem(
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
    val pictures: List<OPicture>? = listOf(),
    @SerialName("pictures_count")
    val picturesCount: Int? = 0,
    @SerialName("reply")
    val reply: Int? = 0,
//    @SerialName("role")
//    val role: List<Any>?,
    @SerialName("settings")
    val settings: OSettings? = OSettings(),
//    @SerialName("source")
//    val source: List<Any>?,
    @SerialName("title")
    val title: String? = "",
    @SerialName("upload_time")
    val uploadTime: Int? = 0
)

@Serializable
data class OUser(
    @SerialName("head_url")
    val headUrl: String? = "",
    @SerialName("name")
    val name: String? = "",
    @SerialName("uid")
    val uid: Int? = 0,
    @SerialName("vip")
    val vip: OVip? = OVip()
)

@Serializable
data class OPicture(
    @SerialName("img_height")
    val imgHeight: Int? = 0,
    @SerialName("img_size")
    val imgSize: Double? = 0.0,
    @SerialName("img_src")
    val imgSrc: String? = "",
//    @SerialName("img_tags")
//    val imgTags: Any?,
    @SerialName("img_width")
    val imgWidth: Int? = 0
)

@Serializable
data class OSettings(
    @SerialName("copy_forbidden")
    val copyForbidden: String? = ""
)

@Serializable
data class OVip(
    @SerialName("avatar_subscript")
    val avatarSubscript: Int? = 0,
    @SerialName("due_date")
    val dueDate: Long? = 0,
    @SerialName("label")
    val label: OLabel? = OLabel(),
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
data class OLabel(
    @SerialName("label_theme")
    val labelTheme: String? = "",
    @SerialName("path")
    val path: String? = "",
    @SerialName("text")
    val text: String? = ""
)
