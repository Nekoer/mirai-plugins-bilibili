package com.hcyacg.entity

import kotlinx.serialization.Serializable

import kotlinx.serialization.SerialName


@Serializable
data class BiliBiliText(
    @SerialName("item")
    val item: BTItem? = BTItem(),
    @SerialName("user")
    val user: User? = User()
)

@Serializable
data class BTItem(
    @SerialName("content")
    val content: String? = "",
    @SerialName("ctrl")
    val ctrl: String? = "",
    @SerialName("orig_dy_id")
    val origDyId: Int? = 0,
    @SerialName("pre_dy_id")
    val preDyId: Int? = 0,
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
data class User(
    @SerialName("face")
    val face: String? = "",
    @SerialName("uid")
    val uid: Int? = 0,
    @SerialName("uname")
    val uname: String? = ""
)