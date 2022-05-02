package com.hcyacg.entity

import kotlinx.serialization.Serializable

import kotlinx.serialization.SerialName

@Serializable
data class BiliBiliDynamic(
    @SerialName("code")
    val code: Int? = 0,
    @SerialName("data")
    val `data`: Data? = Data(),
    @SerialName("message")
    val message: String? = "",
    @SerialName("msg")
    val msg: String? = ""
)

@Serializable
data class Data(
    @SerialName("cards")
    val cards: List<Card>? = listOf(),
    @SerialName("_gt_")
    val gt: Int? = 0,
    @SerialName("has_more")
    val hasMore: Int? = 0,
    @SerialName("next_offset")
    val nextOffset: Long? = 0
)

@Serializable
data class Card(
    @SerialName("card")
    val card: String? = "",
    @SerialName("desc")
    val desc: Desc? = Desc(),
    @SerialName("display")
    val display: Display? = Display(),
    @SerialName("extend_json")
    val extendJson: String? = "",
    @SerialName("extra")
    val extra: Extra? = Extra()
)

@Serializable
data class Desc(
    @SerialName("acl")
    val acl: Int? = 0,
    @SerialName("comment")
    val comment: Int? = 0,
    @SerialName("dynamic_id")
    val dynamicId: Long? = 0,
    @SerialName("dynamic_id_str")
    val dynamicIdStr: String? = "",
    @SerialName("inner_id")
    val innerId: Int? = 0,
    @SerialName("is_liked")
    val isLiked: Int? = 0,
    @SerialName("like")
    val like: Int? = 0,
    @SerialName("orig_dy_id")
    val origDyId: Long? = 0,
    @SerialName("orig_dy_id_str")
    val origDyIdStr: String? = "",
    @SerialName("orig_type")
    val origType: Int? = 0,
    @SerialName("origin")
    val origin: Origin? = Origin(),
    @SerialName("pre_dy_id")
    val preDyId: Long? = 0,
    @SerialName("pre_dy_id_str")
    val preDyIdStr: String? = "",
    @SerialName("r_type")
    val rType: Int? = 0,
    @SerialName("repost")
    val repost: Int? = 0,
    @SerialName("rid")
    val rid: Long? = 0,
    @SerialName("rid_str")
    val ridStr: String? = "",
    @SerialName("status")
    val status: Int? = 0,
    @SerialName("stype")
    val stype: Int? = 0,
    @SerialName("timestamp")
    val timestamp: Int? = 0,
    @SerialName("type")
    val type: Int? = 0,
    @SerialName("uid")
    val uid: Int? = 0,
    @SerialName("uid_type")
    val uidType: Int? = 0,
    @SerialName("user_profile")
    val userProfile: UserProfile? = UserProfile(),
    @SerialName("view")
    val view: Int? = 0
)

@Serializable
data class Display(
    @SerialName("comment_info")
    val commentInfo: CommentInfo? = CommentInfo(),
    @SerialName("emoji_info")
    val emojiInfo: EmojiInfo? = EmojiInfo(),
    @SerialName("origin")
    val origin: OriginX? = OriginX(),
    @SerialName("relation")
    val relation: RelationX? = RelationX()
)

@Serializable
data class Extra(
    @SerialName("is_space_top")
    val isSpaceTop: Int? = 0
)

@Serializable
data class Origin(
    @SerialName("acl")
    val acl: Int? = 0,
    @SerialName("dynamic_id")
    val dynamicId: Long? = 0,
    @SerialName("dynamic_id_str")
    val dynamicIdStr: String? = "",
    @SerialName("inner_id")
    val innerId: Int? = 0,
    @SerialName("like")
    val like: Int? = 0,
    @SerialName("orig_dy_id")
    val origDyId: Int? = 0,
    @SerialName("orig_dy_id_str")
    val origDyIdStr: String? = "",
    @SerialName("pre_dy_id")
    val preDyId: Int? = 0,
    @SerialName("pre_dy_id_str")
    val preDyIdStr: String? = "",
    @SerialName("r_type")
    val rType: Int? = 0,
    @SerialName("repost")
    val repost: Int? = 0,
    @SerialName("rid")
    val rid: Int? = 0,
    @SerialName("rid_str")
    val ridStr: String? = "",
    @SerialName("status")
    val status: Int? = 0,
    @SerialName("stype")
    val stype: Int? = 0,
    @SerialName("timestamp")
    val timestamp: Int? = 0,
    @SerialName("type")
    val type: Int? = 0,
    @SerialName("uid")
    val uid: Int? = 0,
    @SerialName("uid_type")
    val uidType: Int? = 0,
    @SerialName("view")
    val view: Int? = 0
)

@Serializable
data class UserProfile(
    @SerialName("card")
    val card: CardX? = CardX(),
    @SerialName("decorate_card")
    val decorateCard: DecorateCard? = DecorateCard(),
    @SerialName("info")
    val info: Info? = Info(),
    @SerialName("level_info")
    val levelInfo: LevelInfo? = LevelInfo(),
    @SerialName("pendant")
    val pendant: Pendant? = Pendant(),
    @SerialName("rank")
    val rank: String? = "",
    @SerialName("sign")
    val sign: String? = "",
    @SerialName("vip")
    val vip: Vip? = Vip()
)

@Serializable
data class CardX(
    @SerialName("official_verify")
    val officialVerify: OfficialVerify? = OfficialVerify()
)

@Serializable
data class DecorateCard(
    @SerialName("big_card_url")
    val bigCardUrl: String? = "",
    @SerialName("card_type")
    val cardType: Int? = 0,
    @SerialName("card_type_name")
    val cardTypeName: String? = "",
    @SerialName("card_url")
    val cardUrl: String? = "",
    @SerialName("expire_time")
    val expireTime: Int? = 0,
    @SerialName("fan")
    val fan: Fan? = Fan(),
    @SerialName("id")
    val id: Int? = 0,
    @SerialName("image_enhance")
    val imageEnhance: String? = "",
    @SerialName("item_id")
    val itemId: Int? = 0,
    @SerialName("item_type")
    val itemType: Int? = 0,
    @SerialName("jump_url")
    val jumpUrl: String? = "",
    @SerialName("mid")
    val mid: Int? = 0,
    @SerialName("name")
    val name: String? = "",
    @SerialName("uid")
    val uid: Int? = 0
)

@Serializable
data class Info(
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
data class LevelInfo(
    @SerialName("current_level")
    val currentLevel: Int? = 0
)

@Serializable
data class Pendant(
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
data class Vip(
    @SerialName("avatar_subscript")
    val avatarSubscript: Int? = 0,
    @SerialName("avatar_subscript_url")
    val avatarSubscriptUrl: String? = "",
    @SerialName("label")
    val label: Label? = Label(),
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
data class OfficialVerify(
    @SerialName("desc")
    val desc: String? = "",
    @SerialName("type")
    val type: Int? = 0
)

@Serializable
data class Fan(
    @SerialName("color")
    val color: String? = "",
    @SerialName("is_fan")
    val isFan: Int? = 0,
    @SerialName("num_desc")
    val numDesc: String? = "",
    @SerialName("number")
    val number: Int? = 0
)

@Serializable
data class Label(
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
data class CommentInfo(
    @SerialName("comment_ids")
    val commentIds: String? = ""
)

@Serializable
data class EmojiInfo(
    @SerialName("emoji_details")
    val emojiDetails: List<EmojiDetail>? = listOf()
)

@Serializable
data class OriginX(
    @SerialName("add_on_card_info")
    val addOnCardInfo: List<AddOnCardInfo>? = listOf(),
    @SerialName("attach_card")
    val attachCard: AttachCardX? = AttachCardX(),
    @SerialName("emoji_info")
    val emojiInfo: EmojiInfoX? = EmojiInfoX(),
    @SerialName("relation")
    val relation: Relation? = Relation(),
    @SerialName("show_tip")
    val showTip: ShowTip? = ShowTip(),
    @SerialName("topic_info")
    val topicInfo: TopicInfo? = TopicInfo()
)

@Serializable
data class RelationX(
    @SerialName("is_follow")
    val isFollow: Int? = 0,
    @SerialName("is_followed")
    val isFollowed: Int? = 0,
    @SerialName("status")
    val status: Int? = 0
)

@Serializable
data class EmojiDetail(
    @SerialName("attr")
    val attr: Int? = 0,
    @SerialName("emoji_name")
    val emojiName: String? = "",
    @SerialName("id")
    val id: Int? = 0,
    @SerialName("meta")
    val meta: Meta? = Meta(),
    @SerialName("mtime")
    val mtime: Int? = 0,
    @SerialName("package_id")
    val packageId: Int? = 0,
    @SerialName("state")
    val state: Int? = 0,
    @SerialName("text")
    val text: String? = "",
    @SerialName("type")
    val type: Int? = 0,
    @SerialName("url")
    val url: String? = ""
)

@Serializable
data class Meta(
    @SerialName("size")
    val size: Int? = 0
)

@Serializable
data class AddOnCardInfo(
    @SerialName("add_on_card_show_type")
    val addOnCardShowType: Int? = 0,
    @SerialName("attach_card")
    val attachCard: AttachCard? = AttachCard()
)

@Serializable
data class AttachCardX(
    @SerialName("button")
    val button: ButtonX? = ButtonX(),
    @SerialName("cover_type")
    val coverType: Int? = 0,
    @SerialName("cover_url")
    val coverUrl: String? = "",
    @SerialName("desc_first")
    val descFirst: String? = "",
    @SerialName("desc_second")
    val descSecond: String? = "",
    @SerialName("head_text")
    val headText: String? = "",
    @SerialName("jump_url")
    val jumpUrl: String? = "",
    @SerialName("oid_str")
    val oidStr: String? = "",
    @SerialName("title")
    val title: String? = "",
    @SerialName("type")
    val type: String? = ""
)

@Serializable
data class EmojiInfoX(
    @SerialName("emoji_details")
    val emojiDetails: List<EmojiDetailX>? = listOf()
)

@Serializable
data class Relation(
    @SerialName("is_follow")
    val isFollow: Int? = 0,
    @SerialName("is_followed")
    val isFollowed: Int? = 0,
    @SerialName("status")
    val status: Int? = 0
)

@Serializable
data class ShowTip(
    @SerialName("del_tip")
    val delTip: String? = ""
)

@Serializable
data class TopicInfo(
    @SerialName("topic_details")
    val topicDetails: List<TopicDetail>? = listOf()
)

@Serializable
data class AttachCard(
    @SerialName("button")
    val button: Button? = Button(),
    @SerialName("cover_type")
    val coverType: Int? = 0,
    @SerialName("cover_url")
    val coverUrl: String? = "",
    @SerialName("desc_first")
    val descFirst: String? = "",
    @SerialName("desc_second")
    val descSecond: String? = "",
    @SerialName("head_text")
    val headText: String? = "",
    @SerialName("jump_url")
    val jumpUrl: String? = "",
    @SerialName("oid_str")
    val oidStr: String? = "",
    @SerialName("title")
    val title: String? = "",
    @SerialName("type")
    val type: String? = ""
)

@Serializable
data class Button(
    @SerialName("check")
    val check: Check? = Check(),
    @SerialName("status")
    val status: Int? = 0,
    @SerialName("type")
    val type: Int? = 0,
    @SerialName("uncheck")
    val uncheck: Uncheck? = Uncheck()
)

@Serializable
data class Check(
    @SerialName("icon")
    val icon: String? = "",
    @SerialName("text")
    val text: String? = ""
)

@Serializable
data class Uncheck(
    @SerialName("icon")
    val icon: String? = "",
    @SerialName("text")
    val text: String? = ""
)

@Serializable
data class ButtonX(
    @SerialName("check")
    val check: CheckX? = CheckX(),
    @SerialName("status")
    val status: Int? = 0,
    @SerialName("type")
    val type: Int? = 0,
    @SerialName("uncheck")
    val uncheck: UncheckX? = UncheckX()
)

@Serializable
data class CheckX(
    @SerialName("icon")
    val icon: String? = "",
    @SerialName("text")
    val text: String? = ""
)

@Serializable
data class UncheckX(
    @SerialName("icon")
    val icon: String? = "",
    @SerialName("text")
    val text: String? = ""
)

@Serializable
data class EmojiDetailX(
    @SerialName("attr")
    val attr: Int? = 0,
    @SerialName("emoji_name")
    val emojiName: String? = "",
    @SerialName("id")
    val id: Int? = 0,
    @SerialName("meta")
    val meta: MetaX? = MetaX(),
    @SerialName("mtime")
    val mtime: Int? = 0,
    @SerialName("package_id")
    val packageId: Int? = 0,
    @SerialName("state")
    val state: Int? = 0,
    @SerialName("text")
    val text: String? = "",
    @SerialName("type")
    val type: Int? = 0,
    @SerialName("url")
    val url: String? = ""
)

@Serializable
data class MetaX(
    @SerialName("size")
    val size: Int? = 0
)

@Serializable
data class TopicDetail(
    @SerialName("is_activity")
    val isActivity: Int? = 0,
    @SerialName("topic_id")
    val topicId: Int? = 0,
    @SerialName("topic_link")
    val topicLink: String? = "",
    @SerialName("topic_name")
    val topicName: String? = ""
)