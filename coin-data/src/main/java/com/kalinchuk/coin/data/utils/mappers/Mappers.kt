package com.kalinchuk.coin.data.utils.mappers

import com.kalinchuk.coin.data.models.Coin
import com.kalinchuk.coin.data.models.Roi
import com.kalinchuk.coin.database.models.CoinEntity
import com.kalinchuk.coin.database.models.RoiEntity
import com.kalinchuk.coingeckoapi.models.CoinDTO
import com.kalinchuk.coingeckoapi.models.RoiDTO

fun CoinEntity.toCoin(): Coin = Coin(
    id = this.id,
    symbol = this.symbol,
    name = this.name,
    image = this.image,
    currentPrice = this.currentPrice,
    marketCap = this.marketCap,
    marketCapRank = this.marketCapRank,
    fullyDilutedValuation = this.fullyDilutedValuation,
    totalVolume = this.totalVolume,
    highPerDay = this.highPerDay,
    lowPerDay = this.lowPerDay,
    priceChangePerDay = this.priceChangePerDay,
    priceChangePercentagePerDay = this.priceChangePercentagePerDay,
    marketCapChangePerDay = this.marketCapChangePerDay,
    marketCapChangePercentagePerDay = this.marketCapChangePercentagePerDay,
    circulatingSupply = this.circulatingSupply,
    totalSupply = this.totalSupply,
    maxSupply = this.maxSupply,
    ath = this.ath,
    athChangePercentage = this.athChangePercentage,
    athDate = this.athDate,
    atl = this.atl,
    atlChangePercentage = this.atlChangePercentage,
    atlDate = this.atlDate,
    roi = this.roi?.toRoi(),
    lastUpdated = this.lastUpdated
)

fun RoiEntity.toRoi(): Roi = Roi(
    times = this.times,
    currency = this.currency,
    percentage = this.percentage
)

fun CoinDTO.toCoinEntity(): CoinEntity = CoinEntity(
    id = this.id,
    symbol = this.symbol,
    name = this.name,
    image = this.image,
    currentPrice = this.currentPrice,
    marketCap = this.marketCap,
    marketCapRank = this.marketCapRank,
    fullyDilutedValuation = this.fullyDilutedValuation,
    totalVolume = this.totalVolume,
    highPerDay = this.highPerDay,
    lowPerDay = this.lowPerDay,
    priceChangePerDay = this.priceChangePerDay,
    priceChangePercentagePerDay = this.priceChangePercentagePerDay,
    marketCapChangePerDay = this.marketCapChangePerDay,
    marketCapChangePercentagePerDay = this.marketCapChangePercentagePerDay,
    circulatingSupply = this.circulatingSupply,
    totalSupply = this.totalSupply,
    maxSupply = this.maxSupply,
    ath = this.ath,
    athChangePercentage = this.athChangePercentage,
    athDate = this.athDate,
    atl = this.atl,
    atlChangePercentage = this.atlChangePercentage,
    atlDate = this.atlDate,
    roi = this.roi?.toRoiEntity(),
    lastUpdated = this.lastUpdated
)

fun RoiDTO.toRoiEntity(): RoiEntity = RoiEntity(
    times = this.times,
    currency = this.currency,
    percentage = this.percentage
)