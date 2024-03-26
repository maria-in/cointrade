package com.kalinchuk.coingeckoapi.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PingResponse(
    @SerialName("gecko_says") val geckoSays: String
)
