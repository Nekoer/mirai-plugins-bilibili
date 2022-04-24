package com.hcyacg.entity

import com.alibaba.fastjson.annotation.JSONField


data class BiliBiliDynamic(
    @JSONField(name = "code")
    val code: Int?,
    @JSONField(name = "data")
    val `data`: BDIData?,
    @JSONField(name = "message")
    val message: String?,
    @JSONField(name = "msg")
    val msg: String?
)

data class BDIData(
    @JSONField(name = "cards")
    val cards: List<Card>? = listOf(),
    @JSONField(name = "_gt_")
    val gt: Int?,
    @JSONField(name = "has_more")
    val hasMore: Int?,
    @JSONField(name = "next_offset")
    val nextOffset: Long?
)

data class Card(
    @JSONField(name = "card")
    val card: String?,
    @JSONField(name = "desc")
    val desc: Desc?,
    @JSONField(name = "display")
    val display: Display?,
    @JSONField(name = "extend_json")
    val extendJson: String?,
    @JSONField(name = "extra")
    val extra: Extra?
)

data class Desc(
    @JSONField(name = "acl")
    val acl: Int?,
    @JSONField(name = "bvid")
    val bvid: String?,
    @JSONField(name = "comment")
    val comment: Int?,
    @JSONField(name = "dynamic_id")
    val dynamicId: Long?,
    @JSONField(name = "dynamic_id_str")
    val dynamicIdStr: String?,
    @JSONField(name = "inner_id")
    val innerId: Int?,
    @JSONField(name = "is_liked")
    val isLiked: Int?,
    @JSONField(name = "like")
    val like: Int?,
    @JSONField(name = "orig_dy_id")
    val origDyId: Long?,
    @JSONField(name = "orig_dy_id_str")
    val origDyIdStr: String?,
    @JSONField(name = "orig_type")
    val origType: Int?,
    @JSONField(name = "origin")
    val origin: Origin? = Origin(),
    @JSONField(name = "pre_dy_id")
    val preDyId: Long?,
    @JSONField(name = "pre_dy_id_str")
    val preDyIdStr: String?,
    @JSONField(name = "r_type")
    val rType: Int?,
    @JSONField(name = "repost")
    val repost: Int?,
    @JSONField(name = "rid")
    val rid: Long?,
    @JSONField(name = "rid_str")
    val ridStr: String?,
    @JSONField(name = "status")
    val status: Int?,
    @JSONField(name = "stype")
    val stype: Int?,
    @JSONField(name = "timestamp")
    val timestamp: Long?,
    @JSONField(name = "type")
    val type: Int?,
    @JSONField(name = "uid")
    val uid: Long?,
    @JSONField(name = "uid_type")
    val uidType: Int?,
    @JSONField(name = "user_profile")
    val userProfile: UserProfile? = UserProfile(),
    @JSONField(name = "view")
    val view: Int?
)

data class Display(
    @JSONField(name = "comment_info")
    val commentInfo: CommentInfo? = CommentInfo(),
    @JSONField(name = "cover_play_icon_url")
    val coverPlayIconUrl: String? = "",
    @JSONField(name = "origin")
    val origin: OriginX? = OriginX(),
    @JSONField(name = "relation")
    val relation: RelationX? = RelationX(),
    @JSONField(name = "show_tip")
    val showTip: ShowTipX? = ShowTipX(),
    @JSONField(name = "rich_text")
    val richText: RichText? = RichText(),
    @JSONField(name = "topic_info")
    val topicInfo: TopicInfoX? = TopicInfoX(),
    @JSONField(name = "usr_action_txt")
    val usrActionTxt: String? = ""
)

data class RichText(
    @JSONField(name = "rich_details")
    val richDetails: List<RichDetail> = listOf()
)

data class RichDetail(

    @JSONField(name = "icon_type")
    val iconType: Int = 0,
    @JSONField(name = "jump_uri")
    val jumpUri: String = "",
    @JSONField(name = "orig_text")
    val origText: String = "",
    @JSONField(name = "text")
    val text: String = ""

)

data class Extra(
    @JSONField(name = "is_space_top")
    val isSpaceTop: Int = 0
)

data class Origin(
    @JSONField(name = "acl")
    val acl: Int = 0,
    @JSONField(name = "dynamic_id")
    val dynamicId: Long = 0,
    @JSONField(name = "dynamic_id_str")
    val dynamicIdStr: String = "",
    @JSONField(name = "inner_id")
    val innerId: Int = 0,
    @JSONField(name = "like")
    val like: Int = 0,
    @JSONField(name = "orig_dy_id")
    val origDyId: Int = 0,
    @JSONField(name = "orig_dy_id_str")
    val origDyIdStr: String = "",
    @JSONField(name = "pre_dy_id")
    val preDyId: Int = 0,
    @JSONField(name = "pre_dy_id_str")
    val preDyIdStr: String = "",
    @JSONField(name = "r_type")
    val rType: Int = 0,
    @JSONField(name = "repost")
    val repost: Int = 0,
    @JSONField(name = "rid")
    val rid: Long = 0,
    @JSONField(name = "rid_str")
    val ridStr: String = "",
    @JSONField(name = "status")
    val status: Int = 0,
    @JSONField(name = "stype")
    val stype: Int = 0,
    @JSONField(name = "timestamp")
    val timestamp: Int = 0,
    @JSONField(name = "type")
    val type: Int = 0,
    @JSONField(name = "uid")
    val uid: Int = 0,
    @JSONField(name = "uid_type")
    val uidType: Int = 0,
    @JSONField(name = "view")
    val view: Int = 0
)

data class UserProfile(
    @JSONField(name = "card")
    val card: CardX = CardX(),
    @JSONField(name = "decorate_card")
    val decorateCard: DecorateCard? = DecorateCard(),
    @JSONField(name = "info")
    val info: Info = Info(),
    @JSONField(name = "level_info")
    val levelInfo: LevelInfo = LevelInfo(),
    @JSONField(name = "pendant")
    val pendant: BDPendant = BDPendant(),
    @JSONField(name = "rank")
    val rank: String = "",
    @JSONField(name = "sign")
    val sign: String = "",
    @JSONField(name = "vip")
    val vip: BDVip = BDVip()
)

data class CardX(
    @JSONField(name = "official_verify")
    val officialVerify: BDOfficialVerify = BDOfficialVerify()
)

data class DecorateCard(
    @JSONField(name = "big_card_url")
    val bigCardUrl: String = "",
    @JSONField(name = "card_type")
    val cardType: Int = 0,
    @JSONField(name = "card_type_name")
    val cardTypeName: String = "",
    @JSONField(name = "card_url")
    val cardUrl: String = "",
    @JSONField(name = "expire_time")
    val expireTime: Int = 0,
    @JSONField(name = "fan")
    val fan: Fan = Fan(),
    @JSONField(name = "id")
    val id: Int = 0,
    @JSONField(name = "image_enhance")
    val imageEnhance: String = "",
    @JSONField(name = "item_id")
    val itemId: Int = 0,
    @JSONField(name = "item_type")
    val itemType: Int = 0,
    @JSONField(name = "jump_url")
    val jumpUrl: String = "",
    @JSONField(name = "mid")
    val mid: Int = 0,
    @JSONField(name = "name")
    val name: String = "",
    @JSONField(name = "uid")
    val uid: Int = 0
)

data class Info(
    @JSONField(name = "face")
    val face: String = "",
    @JSONField(name = "face_nft")
    val faceNft: Int = 0,
    @JSONField(name = "uid")
    val uid: Int = 0,
    @JSONField(name = "uname")
    val uname: String = ""
)

data class LevelInfo(
    @JSONField(name = "current_level")
    val currentLevel: Int = 0
)

data class BDPendant(
    @JSONField(name = "expire")
    val expire: Int = 0,
    @JSONField(name = "image")
    val image: String = "",
    @JSONField(name = "image_enhance")
    val imageEnhance: String = "",
    @JSONField(name = "image_enhance_frame")
    val imageEnhanceFrame: String = "",
    @JSONField(name = "name")
    val name: String = "",
    @JSONField(name = "pid")
    val pid: Int = 0
)

data class BDVip(
    @JSONField(name = "avatar_subscript")
    val avatarSubscript: Int = 0,
    @JSONField(name = "avatar_subscript_url")
    val avatarSubscriptUrl: String = "",
    @JSONField(name = "label")
    val label: BDLabel = BDLabel(),
    @JSONField(name = "nickname_color")
    val nicknameColor: String = "",
    @JSONField(name = "role")
    val role: Int = 0,
    @JSONField(name = "themeType")
    val themeType: Int = 0,
    @JSONField(name = "vipDueDate")
    val vipDueDate: Long = 0,
    @JSONField(name = "vipStatus")
    val vipStatus: Int = 0,
    @JSONField(name = "vipType")
    val vipType: Int = 0
)

data class BDOfficialVerify(
    @JSONField(name = "desc")
    val desc: String = "",
    @JSONField(name = "type")
    val type: Int = 0
)

data class Fan(
    @JSONField(name = "color")
    val color: String = "",
    @JSONField(name = "is_fan")
    val isFan: Int = 0,
    @JSONField(name = "num_desc")
    val numDesc: String = "",
    @JSONField(name = "number")
    val number: Int = 0
)

data class BDLabel(
    @JSONField(name = "bg_color")
    val bgColor: String = "",
    @JSONField(name = "bg_style")
    val bgStyle: Int = 0,
    @JSONField(name = "border_color")
    val borderColor: String = "",
    @JSONField(name = "label_theme")
    val labelTheme: String = "",
    @JSONField(name = "path")
    val path: String = "",
    @JSONField(name = "text")
    val text: String = "",
    @JSONField(name = "text_color")
    val textColor: String = ""
)

data class CommentInfo(
    @JSONField(name = "comment_ids")
    val commentIds: String = ""
)

data class OriginX(
    @JSONField(name = "emoji_info")
    val emojiInfo: EmojiInfo? = EmojiInfo(),
    @JSONField(name = "relation")
    val relation: Relation? = Relation(),
    @JSONField(name = "show_tip")
    val showTip: ShowTip? = ShowTip(),
    @JSONField(name = "topic_info")
    val topicInfo: TopicInfo? = TopicInfo()
)

data class RelationX(
    @JSONField(name = "is_follow")
    val isFollow: Int = 0,
    @JSONField(name = "is_followed")
    val isFollowed: Int = 0,
    @JSONField(name = "status")
    val status: Int = 0
)

data class ShowTipX(
    @JSONField(name = "del_tip")
    val delTip: String = ""
)

data class TopicInfoX(
    @JSONField(name = "new_topic")
    val newTopic: NewTopic? = NewTopic(),
    @JSONField(name = "topic_details")
    val topicDetails: List<TopicDetailX>? = listOf()
)

data class EmojiInfo(
    @JSONField(name = "emoji_details")
    val emojiDetails: List<EmojiDetail> = listOf()
)

data class Relation(
    @JSONField(name = "is_follow")
    val isFollow: Int = 0,
    @JSONField(name = "is_followed")
    val isFollowed: Int = 0,
    @JSONField(name = "status")
    val status: Int = 0
)

data class ShowTip(
    @JSONField(name = "del_tip")
    val delTip: String = ""
)

data class TopicInfo(
    @JSONField(name = "topic_details")
    val topicDetails: List<TopicDetail>? = listOf()
)

data class EmojiDetail(
    @JSONField(name = "attr")
    val attr: Int = 0,
    @JSONField(name = "emoji_name")
    val emojiName: String = "",
    @JSONField(name = "id")
    val id: Int = 0,
    @JSONField(name = "meta")
    val meta: Meta = Meta(),
    @JSONField(name = "mtime")
    val mtime: Int = 0,
    @JSONField(name = "package_id")
    val packageId: Int = 0,
    @JSONField(name = "state")
    val state: Int = 0,
    @JSONField(name = "text")
    val text: String? = "",
    @JSONField(name = "type")
    val type: Int? = 0,
    @JSONField(name = "url")
    val url: String? = ""
)

data class Meta(
    @JSONField(name = "size")
    val size: Int? = 0
)

data class TopicDetail(
    @JSONField(name = "is_activity")
    val isActivity: Int? = 0,
    @JSONField(name = "topic_id")
    val topicId: Int? = 0,
    @JSONField(name = "topic_link")
    val topicLink: String? = "",
    @JSONField(name = "topic_name")
    val topicName: String? = ""
)

data class NewTopic(
    @JSONField(name = "id")
    val id: Int? = 0,
    @JSONField(name = "link")
    val link: String? = "",
    @JSONField(name = "name")
    val name: String? = ""
)

data class TopicDetailX(
    @JSONField(name = "is_activity")
    val isActivity: Int? = 0,
    @JSONField(name = "topic_id")
    val topicId: Int? = 0,
    @JSONField(name = "topic_link")
    val topicLink: String? = "",
    @JSONField(name = "topic_name")
    val topicName: String? = ""
)