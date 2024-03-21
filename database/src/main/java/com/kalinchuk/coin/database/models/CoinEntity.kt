package com.kalinchuk.coin.database.models

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "coin_list")
data class CoinEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo("id")
    val id: String,
    @ColumnInfo("symbol")
    val symbol: String,
    @ColumnInfo("name")
    val name: String,
    @ColumnInfo("image")
    val image: String,
    @ColumnInfo("current_price")
    val currentPrice: Float,
    @ColumnInfo("market_cap")
    val marketCap: Float,
    @ColumnInfo("market_cap_rank")
    val marketCapRank: Int,
    @ColumnInfo("fully_diluted_valuation")
    val fullyDilutedValuation: Long,
    @ColumnInfo("total_volume")
    val totalVolume: Long,
    @ColumnInfo("high_24h")
    val highPerDay: Float,
    @ColumnInfo("low_24h")
    val lowPerDay: Float,
    @ColumnInfo("price_change_24h")
    val priceChangePerDay: Float,
    @ColumnInfo("price_change_percentage_24h")
    val priceChangePercentagePerDay: Float,
    @ColumnInfo("market_cap_change_24h")
    val marketCapChangePerDay: Float,
    @ColumnInfo("market_cap_change_percentage_24h")
    val marketCapChangePercentagePerDay: Float,
    @ColumnInfo("circulating_supply")
    val circulatingSupply: Float,
    @ColumnInfo("total_supply")
    val totalSupply: Float,
    @ColumnInfo("max_supply")
    val maxSupply: Float?,
    @ColumnInfo("ath")
    val ath: Float,
    @ColumnInfo("ath_change_percentage")
    val athChangePercentage: Float,
    @ColumnInfo("ath_date")
    val athDate: Date,
    @ColumnInfo("atl")
    val atl: Float,
    @ColumnInfo("atl_change_percentage")
    val atlChangePercentage: Float,
    @ColumnInfo("atl_date")
    val atlDate: Date,
    @Embedded(prefix = "roi_")
    val roi: RoiEntity?,
    @ColumnInfo("last_updated")
    val lastUpdated: Date
)

data class RoiEntity(
    val times: Float,
    val currency: String,
    val percentage: Float
)
