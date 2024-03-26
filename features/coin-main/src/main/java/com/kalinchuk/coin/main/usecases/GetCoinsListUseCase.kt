package com.kalinchuk.coin.main.usecases

import com.kalinchuk.coin.data.CoinsRepository
import com.kalinchuk.coin.data.models.Coin
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

internal class GetCoinsListUseCase @Inject constructor(
    private val repository: CoinsRepository
) {
    operator fun invoke(): Flow<List<Coin>> {
        return flow { emit(emptyList()) }
    }
}