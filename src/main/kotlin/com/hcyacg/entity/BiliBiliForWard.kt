package com.hcyacg.entity

import com.alibaba.fastjson.annotation.JSONField


data class BiliBiliForWard(
    @JSONField(name = "item")
    val item: BFWItem?,
    @JSONField(name = "origin")
    val origin: String?,
    @JSONField(name = "origin_extend_json")
    val originExtendJson: String?,
    @JSONField(name = "origin_user")
    val originUser: OriginUser?,
    @JSONField(name = "user")
    val user: UserX?
)

data class BFWItem(
    @JSONField(name = "content")
    val content: String?,
    @JSONField(name = "ctrl")
    val ctrl: String?,
    @JSONField(name = "orig_dy_id")
    val origDyId: Long?,
    @JSONField(name = "orig_type")
    val origType: Int?,
    @JSONField(name = "pre_dy_id")
    val preDyId: Long?,
    @JSONField(name = "reply")
    val reply: Int?,
    @JSONField(name = "rp_id")
    val rpId: Long?,
    @JSONField(name = "timestamp")
    val timestamp: Int?,
    @JSONField(name = "uid")
    val uid: Int?
)

data class OriginUser(
    @JSONField(name = "card")
    val card: BFWCard?,
    @JSONField(name = "info")
    val info: BFWInfo?,
    @JSONField(name = "level_info")
    val levelInfo: BFWLevelInfo?,
    @JSONField(name = "pendant")
    val pendant: BFWPendant?,
    @JSONField(name = "rank")
    val rank: String?,
    @JSONField(name = "sign")
    val sign: String?,
    @JSONField(name = "vip")
    val vip: VipX?
)

data class UserX(
    @JSONField(name = "face")
    val face: String?,
    @JSONField(name = "uid")
    val uid: Int?,
    @JSONField(name = "uname")
    val uname: String?
)

data class BFWLabel(
    @JSONField(name = "label_theme")
    val labelTheme: String?,
    @JSONField(name = "path")
    val path: String?,
    @JSONField(name = "text")
    val text: String?
)


data class Verify(
    @JSONField(name = "asw")
    val asw: Asw?,
    @JSONField(name = "cc")
    val cc: Cc?,
    @JSONField(name = "csw")
    val csw: Csw?,
    @JSONField(name = "dc")
    val dc: Dc?,
    @JSONField(name = "gc")
    val gc: Gc?,
    @JSONField(name = "ra")
    val ra: Ra?,
    @JSONField(name = "sp")
    val sp: Sp?,
    @JSONField(name = "sw")
    val sw: Sw?,
    @JSONField(name = "ur")
    val ur: Ur?
)

data class Asw(
    @JSONField(name = "fl")
    val fl: Int?,
    @JSONField(name = "nv")
    val nv: Int?
)

class Cc

class Csw

class Dc

class Gc

class Ra

class Sp

data class Sw(
    @JSONField(name = "fl")
    val fl: Int?,
    @JSONField(name = "nv")
    val nv: Int?
)

class Ur

data class BFWCard(
    @JSONField(name = "official_verify")
    val officialVerify: BFWOfficialVerify?
)

data class BFWInfo(
    @JSONField(name = "face")
    val face: String?,
    @JSONField(name = "face_nft")
    val faceNft: Int?,
    @JSONField(name = "uid")
    val uid: Int?,
    @JSONField(name = "uname")
    val uname: String?
)

data class BFWLevelInfo(
    @JSONField(name = "current_level")
    val currentLevel: Int?
)

data class BFWPendant(
    @JSONField(name = "expire")
    val expire: Int?,
    @JSONField(name = "image")
    val image: String?,
    @JSONField(name = "image_enhance")
    val imageEnhance: String?,
    @JSONField(name = "image_enhance_frame")
    val imageEnhanceFrame: String?,
    @JSONField(name = "name")
    val name: String?,
    @JSONField(name = "pid")
    val pid: Int?
)

data class VipX(
    @JSONField(name = "avatar_subscript")
    val avatarSubscript: Int?,
    @JSONField(name = "avatar_subscript_url")
    val avatarSubscriptUrl: String?,
    @JSONField(name = "label")
    val label: LabelX?,
    @JSONField(name = "nickname_color")
    val nicknameColor: String?,
    @JSONField(name = "role")
    val role: Int?,
    @JSONField(name = "themeType")
    val themeType: Int?,
    @JSONField(name = "vipDueDate")
    val vipDueDate: Long?,
    @JSONField(name = "vipStatus")
    val vipStatus: Int?,
    @JSONField(name = "vipType")
    val vipType: Int?
)

data class BFWOfficialVerify(
    @JSONField(name = "desc")
    val desc: String?,
    @JSONField(name = "type")
    val type: Int?
)

data class LabelX(
    @JSONField(name = "bg_color")
    val bgColor: String?,
    @JSONField(name = "bg_style")
    val bgStyle: Int?,
    @JSONField(name = "border_color")
    val borderColor: String?,
    @JSONField(name = "label_theme")
    val labelTheme: String?,
    @JSONField(name = "path")
    val path: String?,
    @JSONField(name = "text")
    val text: String?,
    @JSONField(name = "text_color")
    val textColor: String?
)

data class OriginJson(
    @JSONField(name = "item")
    val item: OItem?,
    @JSONField(name = "user")
    val user: OUser?
)

data class OItem(
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
    val pictures: List<OPicture>?,
    @JSONField(name = "pictures_count")
    val picturesCount: Int?,
    @JSONField(name = "reply")
    val reply: Int?,
    @JSONField(name = "role")
    val role: List<Any>?,
    @JSONField(name = "settings")
    val settings: OSettings?,
    @JSONField(name = "source")
    val source: List<Any>?,
    @JSONField(name = "title")
    val title: String?,
    @JSONField(name = "upload_time")
    val uploadTime: Int?
)

data class OUser(
    @JSONField(name = "head_url")
    val headUrl: String?,
    @JSONField(name = "name")
    val name: String?,
    @JSONField(name = "uid")
    val uid: Int?,
    @JSONField(name = "vip")
    val vip: OVip?
)

data class OPicture(
    @JSONField(name = "img_height")
    val imgHeight: Int?,
    @JSONField(name = "img_size")
    val imgSize: Double?,
    @JSONField(name = "img_src")
    val imgSrc: String?,
    @JSONField(name = "img_tags")
    val imgTags: Any?,
    @JSONField(name = "img_width")
    val imgWidth: Int?
)

data class OSettings(
    @JSONField(name = "copy_forbidden")
    val copyForbidden: String?
)

data class OVip(
    @JSONField(name = "avatar_subscript")
    val avatarSubscript: Int?,
    @JSONField(name = "due_date")
    val dueDate: Long?,
    @JSONField(name = "label")
    val label: OLabel?,
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

data class OLabel(
    @JSONField(name = "label_theme")
    val labelTheme: String?,
    @JSONField(name = "path")
    val path: String?,
    @JSONField(name = "text")
    val text: String?
)
