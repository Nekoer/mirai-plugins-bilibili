package com.hcyacg.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Proxy(
    @SerialName("host")
    val host: String = "",
    @SerialName("port")
    val port: Int = -1
)