package com.hcyacg.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Enable(

    @SerialName("article")
    var article: Boolean = true,
    @SerialName("forward")
    var forward: Boolean = true,
    @SerialName("live")
    var live: Boolean = true,
    @SerialName("video")
    var video: Boolean = true,
    @SerialName("dynamic")
    var dynamic: Boolean = true,
)