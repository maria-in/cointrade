package com.kalinchuk.coin.main.usecases

import com.kalinchuk.coin.data.CoinsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class CheckStatusUseCase @Inject constructor(
    private val repository: CoinsRepository
) {
    operator fun invoke(): Flow<String> {
        return repository.fetchDataFromApi()
    }
}