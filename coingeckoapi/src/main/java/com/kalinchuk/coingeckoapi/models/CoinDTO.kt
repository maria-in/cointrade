package com.kalinchuk.coingeckoapi.models

import com.kalinchuk.coingeckoapi.utils.DateSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.Date

@Serializable
data class CoinDTO(
    @SerialName("id") val id: String,
    @SerialName("symbol") val symbol: String,
    @SerialName("name") val name: String,
    @SerialName("image") val image: String,
    @SerialName("current_price") val currentPrice: Float,
    @SerialName("market_cap") val marketCap: Float,
    @SerialName("market_cap_rank") val marketCapRank: Int,
    @SerialName("fully_diluted_valuation") val fullyDilutedValuation: Long,
    @SerialName("total_volume") val totalVolume: Long,
    @SerialName("high_24h") val highPerDay: Float,
    @SerialName("low_24h") val lowPerDay: Float,
    @SerialName("price_change_24h") val priceChangePerDay: Float,
    @SerialName("price_change_percentage_24h") val priceChangePercentagePerDay: Float,
    @SerialName("market_cap_change_24h") val marketCapChangePerDay: Float,
    @SerialName("market_cap_change_percentage_24h") val marketCapChangePercentagePerDay: Float,
    @SerialName("circulating_supply") val circulatingSupply: Float,
    @SerialName("total_supply") val totalSupply: Float,
    @SerialName("max_supply") val maxSupply: Float?,
    @SerialName("ath") val ath: Float,
    @SerialName("ath_change_percentage") val athChangePercentage: Float,
    @SerialName("ath_date") @Serializable(with = DateSerializer::class) val athDate: Date,
    @SerialName("atl") val atl: Float,
    @SerialName("atl_change_percentage") val atlChangePercentage: Float,
    @SerialName("atl_date") @Serializable(with = DateSerializer::class) val atlDate: Date,
    @SerialName("roi") val roi: Roi?,
    @SerialName("last_updated") @Serializable(with = DateSerializer::class) val lastUpdated: Date
)

@Serializable
data class Roi(
    @SerialName("times") val times: Float,
    @SerialName("currency") val currency: String,
    @SerialName("percentage") val percentage: Float
)