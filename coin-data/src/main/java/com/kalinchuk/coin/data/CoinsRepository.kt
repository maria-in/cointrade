package com.kalinchuk.coin.data

import android.util.Log
import com.kalinchuk.coin.data.models.Coin
import com.kalinchuk.coin.data.utils.mappers.toCoin
import com.kalinchuk.coin.data.utils.mappers.toCoinEntity
import com.kalinchuk.coin.database.CoinDatabase
import com.kalinchuk.coingeckoapi.CoinGeckoApi
import com.kalinchuk.coingeckoapi.models.CoinDTO
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach

class CoinsRepository @Inject constructor(
    private val local: CoinDatabase,
    private val remote: CoinGeckoApi
) {

    fun fetchDataFromApi(): Flow<String> = flow {
        val result = remote.checkServerStatus()
        emit(result.geckoSays)
    }
}

sealed class RequestResult<out E: Any>(internal val data: E? = null) {
    class InProgress<E: Any>(data: E? = null) : RequestResult<E>(data)

    class Success<E : Any>(data: E) : RequestResult<E>(data)

    class Error<E: Any>(data: E? = null) : RequestResult<E>(data)
}

internal fun <T : Any> RequestResult<T>.requireData(): T = checkNotNull(data)
