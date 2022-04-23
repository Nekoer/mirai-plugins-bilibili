package com.hcyacg.entity

import com.alibaba.fastjson.annotation.JSONField


data class BiliBiliLive(
    @JSONField(name = "code")
    val code: Int,
    @JSONField(name = "data")
    val data: BLData?,
    @JSONField(name = "message")
    val message: String,
    @JSONField(name = "ttl")
    val ttl: Int
)

data class BLData(
    @JSONField(name = "birthday")
    val birthday: String,
    @JSONField(name = "coins")
    val coins: Int,
    @JSONField(name = "face")
    val face: String,
    @JSONField(name = "face_nft")
    val faceNft: Int,
    @JSONField(name = "fans_badge")
    val fansBadge: Boolean,
    @JSONField(name = "fans_medal")
    val fansMedal: FansMedal,
    @JSONField(name = "is_followed")
    val isFollowed: Boolean,
    @JSONField(name = "is_senior_member")
    val isSeniorMember: Int,
    @JSONField(name = "jointime")
    val jointime: Int,
    @JSONField(name = "level")
    val level: Int,
    @JSONField(name = "live_room")
    val liveRoom: LiveRoom,
    @JSONField(name = "mid")
    val mid: Int,
    @JSONField(name = "moral")
    val moral: Int,
    @JSONField(name = "name")
    val name: String,
    @JSONField(name = "nameplate")
    val nameplate: BVNameplate,
    @JSONField(name = "official")
    val official: Official,
    @JSONField(name = "pendant")
    val pendant: BVPendant,
    @JSONField(name = "profession")
    val profession: Profession,
    @JSONField(name = "rank")
    val rank: Int,
    @JSONField(name = "school")
    val school: Any?,
    @JSONField(name = "series")
    val series: Series,
    @JSONField(name = "sex")
    val sex: String,
    @JSONField(name = "sign")
    val sign: String,
    @JSONField(name = "silence")
    val silence: Int,
    @JSONField(name = "sys_notice")
    val sysNotice: SysNotice,
    @JSONField(name = "tags")
    val tags: Any?,
    @JSONField(name = "theme")
    val theme: Theme,
    @JSONField(name = "top_photo")
    val topPhoto: String,
    @JSONField(name = "user_honour_info")
    val userHonourInfo: UserHonourInfo,
    @JSONField(name = "vip")
    val vip: BVip
)

data class FansMedal(
    @JSONField(name = "medal")
    val medal: Medal?,
    @JSONField(name = "show")
    val show: Boolean,
    @JSONField(name = "wear")
    val wear: Boolean
)

data class LiveRoom(
    @JSONField(name = "broadcast_type")
    val broadcastType: Int,
    @JSONField(name = "cover")
    val cover: String,
    @JSONField(name = "liveStatus")
    val liveStatus: Int, // 0 未开播 1 开播中 2 轮播中
    @JSONField(name = "online")
    val online: Int,
    @JSONField(name = "roomStatus")
    val roomStatus: Int,
    @JSONField(name = "roomid")
    val roomid: Int,
    @JSONField(name = "roundStatus")
    val roundStatus: Int,
    @JSONField(name = "title")
    val title: String,
    @JSONField(name = "url")
    val url: String
)

data class BVNameplate(
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

data class Official(
    @JSONField(name = "desc")
    val desc: String,
    @JSONField(name = "role")
    val role: Int,
    @JSONField(name = "title")
    val title: String,
    @JSONField(name = "type")
    val type: Int
)

data class BVPendant(
    @JSONField(name = "expire")
    val expire: Int,
    @JSONField(name = "image")
    val image: String,
    @JSONField(name = "image_enhance")
    val imageEnhance: String,
    @JSONField(name = "image_enhance_frame")
    val imageEnhanceFrame: String,
    @JSONField(name = "name")
    val name: String,
    @JSONField(name = "pid")
    val pid: Int
)

data class Profession(
    @JSONField(name = "name")
    val name: String
)

data class Series(
    @JSONField(name = "show_upgrade_window")
    val showUpgradeWindow: Boolean,
    @JSONField(name = "user_upgrade_status")
    val userUpgradeStatus: Int
)

class SysNotice

class Theme

data class UserHonourInfo(
    @JSONField(name = "colour")
    val colour: Any?,
    @JSONField(name = "mid")
    val mid: Int,
    @JSONField(name = "tags")
    val tags: List<Any>
)

data class BVip(
    @JSONField(name = "avatar_subscript")
    val avatarSubscript: Int,
    @JSONField(name = "avatar_subscript_url")
    val avatarSubscriptUrl: String,
    @JSONField(name = "due_date")
    val dueDate: Long,
    @JSONField(name = "label")
    val label: BVLabel,
    @JSONField(name = "nickname_color")
    val nicknameColor: String,
    @JSONField(name = "role")
    val role: Int,
    @JSONField(name = "status")
    val status: Int,
    @JSONField(name = "theme_type")
    val themeType: Int,
    @JSONField(name = "type")
    val type: Int,
    @JSONField(name = "vip_pay_type")
    val vipPayType: Int
)

data class Medal(
    @JSONField(name = "day_limit")
    val dayLimit: Int,
    @JSONField(name = "guard_level")
    val guardLevel: Int,
    @JSONField(name = "intimacy")
    val intimacy: Int,
    @JSONField(name = "is_lighted")
    val isLighted: Int,
    @JSONField(name = "level")
    val level: Int,
    @JSONField(name = "light_status")
    val lightStatus: Int,
    @JSONField(name = "medal_color")
    val medalColor: Int,
    @JSONField(name = "medal_color_border")
    val medalColorBorder: Int,
    @JSONField(name = "medal_color_end")
    val medalColorEnd: Int,
    @JSONField(name = "medal_color_start")
    val medalColorStart: Int,
    @JSONField(name = "medal_id")
    val medalId: Int,
    @JSONField(name = "medal_name")
    val medalName: String,
    @JSONField(name = "next_intimacy")
    val nextIntimacy: Int,
    @JSONField(name = "score")
    val score: Int,
    @JSONField(name = "target_id")
    val targetId: Int,
    @JSONField(name = "uid")
    val uid: Int,
    @JSONField(name = "wearing_status")
    val wearingStatus: Int
)

data class BVLabel(
    @JSONField(name = "bg_color")
    val bgColor: String,
    @JSONField(name = "bg_style")
    val bgStyle: Int,
    @JSONField(name = "border_color")
    val borderColor: String,
    @JSONField(name = "label_theme")
    val labelTheme: String,
    @JSONField(name = "path")
    val path: String,
    @JSONField(name = "text")
    val text: String,
    @JSONField(name = "text_color")
    val textColor: String
)