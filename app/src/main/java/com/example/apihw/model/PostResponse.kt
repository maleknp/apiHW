package com.example.apihw.model
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class Welcome (
    val exchanges: List<Post>
)

@Serializable
data class Post (
    @SerialName("exchange_id")
    val exchangeID: String,

    val name: String,
    val website: String,

    @SerialName("volume_24h")
    val volume24H: Double
)
