package com.kalinchuk.coin.data.models

import java.util.Date

data class Coin(
    val id: String,
    val symbol: String,
    val name: String,
    val image: String,
    val currentPrice: Float,
    val marketCap: Float,
    val marketCapRank: Int,
    val fullyDilutedValuation: Long,
    val totalVolume: Long,
    val highPerDay: Float,
    val lowPerDay: Float,
    val priceChangePerDay: Float,
    val priceChangePercentagePerDay: Float,
    val marketCapChangePerDay: Float,
    val marketCapChangePercentagePerDay: Float,
    val circulatingSupply: Float,
    val totalSupply: Float,
    val maxSupply: Float?,
    val ath: Float,
    val athChangePercentage: Float,
    val athDate: Date,
    val atl: Float,
    val atlChangePercentage: Float,
    val atlDate: Date,
    val roi: Roi?,
    val lastUpdated: Date
)

data class Roi(
    val times: Float,
    val currency: String,
    val percentage: Float
)
