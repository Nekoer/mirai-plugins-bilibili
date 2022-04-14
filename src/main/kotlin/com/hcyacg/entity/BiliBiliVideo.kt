package com.hcyacg.entity

import com.alibaba.fastjson.annotation.JSONField


data class BiliBiliVideo(
    @JSONField(name = "code")
    val code: Int,
    @JSONField(name = "data")
    val data: BVData,
    @JSONField(name = "message")
    val message: String,
    @JSONField(name = "ttl")
    val ttl: Int
)

data class BVData(
    @JSONField(name = "episodic_button")
    val episodicButton: EpisodicButton,
    @JSONField(name = "list")
    val list: BVList,
    @JSONField(name = "page")
    val page: Page
)

data class EpisodicButton(
    @JSONField(name = "text")
    val text: String,
    @JSONField(name = "uri")
    val uri: String
)

data class BVList(
    @JSONField(name = "tlist")
    val tlist: Any?,
    @JSONField(name = "vlist")
    val vlist: List<Vlist>?
)

data class Page(
    @JSONField(name = "count")
    val count: Int,
    @JSONField(name = "pn")
    val pn: Int,
    @JSONField(name = "ps")
    val ps: Int
)

data class Vlist(
    @JSONField(name = "aid")
    val aid: Int,
    @JSONField(name = "author")
    val author: String,
    @JSONField(name = "bvid")
    val bvid: String,
    @JSONField(name = "comment")
    val comment: Int,
    @JSONField(name = "copyright")
    val copyright: String,
    @JSONField(name = "created")
    val created: Long,
    @JSONField(name = "description")
    val description: String,
    @JSONField(name = "hide_click")
    val hideClick: Boolean,
    @JSONField(name = "is_live_playback")
    val isLivePlayback: Int,
    @JSONField(name = "is_pay")
    val isPay: Int,
    @JSONField(name = "is_steins_gate")
    val isSteinsGate: Int,
    @JSONField(name = "is_union_video")
    val isUnionVideo: Int,
    @JSONField(name = "length")
    val length: String,
    @JSONField(name = "mid")
    val mid: Int,
    @JSONField(name = "pic")
    val pic: String,
    @JSONField(name = "play")
    val play: Int,
    @JSONField(name = "review")
    val review: Int,
    @JSONField(name = "subtitle")
    val subtitle: String,
    @JSONField(name = "title")
    val title: String,
    @JSONField(name = "typeid")
    val typeid: Int,
    @JSONField(name = "video_review")
    val videoReview: Int
)