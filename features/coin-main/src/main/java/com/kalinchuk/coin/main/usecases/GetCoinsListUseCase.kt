package com.kalinchuk.coin.main.usecases

import com.kalinchuk.coin.data.CoinsRepository
import com.kalinchuk.coin.data.models.Coin
import kotlinx.coroutines.flow.Flow

class GetCoinsListUseCase(private val repository: CoinsRepository) {
    operator fun invoke(): Flow<List<Coin>> {
        //TODO: add UI convertor here
        return repository.getCoinList()
    }
}