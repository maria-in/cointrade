package com.kalinchuk.coin.data

import com.kalinchuk.coin.data.models.Coin
import com.kalinchuk.coin.data.utils.mappers.toCoin
import com.kalinchuk.coin.data.utils.mappers.toCoinEntity
import com.kalinchuk.coin.database.CoinDatabase
import com.kalinchuk.coin.database.models.CoinEntity
import com.kalinchuk.coingeckoapi.CoinGeckoApi
import com.kalinchuk.coingeckoapi.models.CoinDTO
import jakarta.inject.Inject
import jakarta.inject.Singleton
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.flow.onEach
import java.io.IOException

class CoinsRepository @Inject constructor(
    private val local: CoinDatabase,
    private val remote: CoinGeckoApi
) {
    fun getCoinList(): Flow<List<Coin>> {
//
//        val remote: Flow<RequestResult.Success<*>> = flow {
////            emit(RequestResult.InProgress())
//            emit(remote.getCoinsList())
//        }.map { result ->
//            if (result.isSuccess) {
//                val response = result.getOrThrow()
//                RequestResult.Success(response.body())
//            } else {
//                RequestResult.Error(null)
//            }
//            //TODO: check if null list
//            //TODO: rewrite
//        }.filterIsInstance<RequestResult.Success<List<CoinDTO>>>().map { result ->
//            result.requireData()
//                .map { coinDto -> coinDto.toCoinEntity() }
//                .let { RequestResult.Success(it)}
//        }.onEach { result ->
//            local.coinDao.insertAllCoins(result.requireData())
//        }
//
//       return flow { listOf<Coin>() }

        val remoteData = flow {
            emit(remote.getCoinsList())
        }.filterIsInstance<RequestResult.Success<List<CoinDTO>>>().map { result ->
            result.requireData()
                .map { coinDto -> coinDto.toCoinEntity() }
                .let { RequestResult.Success(it) }
        }.onEach { result ->
            local.coinDao.insertAllCoins(result.requireData())
        }

        val cache = local.coinDao.getCoinsList().map { list -> list.map { it.toCoin() } }

        return cache
    }
}

sealed class RequestResult<out E: Any>(internal val data: E? = null) {
    class InProgress<E: Any>(data: E? = null) : RequestResult<E>(data)

    class Success<E : Any>(data: E) : RequestResult<E>(data)

    class Error<E: Any>(data: E? = null) : RequestResult<E>(data)
}

internal fun <T : Any> RequestResult<T>.requireData(): T = checkNotNull(data)
