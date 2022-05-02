package com.hcyacg.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BiliBiliVideo(
    @SerialName("code")
    val code: Int? = 0,
    @SerialName("data")
    val data: BVData? = BVData(),
    @SerialName("message")
    val message: String? = "",
    @SerialName("ttl")
    val ttl: Int? = 0
)

@Serializable
data class BVData(
    @SerialName("episodic_button")
    val episodicButton: EpisodicButton? = EpisodicButton(),
    @SerialName("list")
    val list: BVList? = BVList(),
    @SerialName("page")
    val page: Page? = Page()
)

@Serializable
data class EpisodicButton(
    @SerialName("text")
    val text: String? = "",
    @SerialName("uri")
    val uri: String? = ""
)

@Serializable
data class BVList(
//    @SerialName("tlist")
//    val tlist: Any?,
    @SerialName("vlist")
    val vlist: List<Vlist>? = listOf()
)

@Serializable
data class Page(
    @SerialName("count")
    val count: Int? = 0,
    @SerialName("pn")
    val pn: Int? = 0,
    @SerialName("ps")
    val ps: Int? = 0
)

@Serializable
data class Vlist(
    @SerialName("aid")
    val aid: Int? = 0,
    @SerialName("author")
    val author: String? = "",
    @SerialName("bvid")
    val bvid: String? = "",
    @SerialName("comment")
    val comment: Int? = 0,
    @SerialName("copyright")
    val copyright: String? = "",
    @SerialName("created")
    val created: Long? = 0,
    @SerialName("description")
    val description: String? = "",
    @SerialName("hide_click")
    val hideClick: Boolean? = false,
    @SerialName("is_live_playback")
    val isLivePlayback: Int? = 0,
    @SerialName("is_pay")
    val isPay: Int? = 0,
    @SerialName("is_steins_gate")
    val isSteinsGate: Int? = 0,
    @SerialName("is_union_video")
    val isUnionVideo: Int? = 0,
    @SerialName("length")
    val length: String? = "",
    @SerialName("mid")
    val mid: Int? = 0,
    @SerialName("pic")
    val pic: String? = "",
    @SerialName("play")
    val play: Int? = 0,
    @SerialName("review")
    val review: Int? = 0,
    @SerialName("subtitle")
    val subtitle: String? = "",
    @SerialName("title")
    val title: String? = "",
    @SerialName("typeid")
    val typeid: Int? = 0,
    @SerialName("video_review")
    val videoReview: Int? = 0
)