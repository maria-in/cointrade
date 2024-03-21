package com.kalinchuk.coin.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kalinchuk.coin.data.CoinsRepository
import com.kalinchuk.coin.data.RequestResult
import com.kalinchuk.coin.data.models.Coin
import com.kalinchuk.coin.main.usecases.GetCoinsListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

internal class CoinsListViewModel(
    private val getCoinsListUseCase: GetCoinsListUseCase
) : ViewModel() {

    val state: SharedFlow<State> =
        getCoinsListUseCase()
            .map { list -> list.toState() }
            .stateIn(viewModelScope, SharingStarted.Lazily, State.None)
}

sealed class State {

    data object None : State()
    data object Loading : State()
    data object Error : State()
    class Success(val coins: List<Coin>) : State()
}

private fun <E : Any> RequestResult<E>.toState() {

}

private fun List<Coin>.toState(): State {
    return if (this.isNotEmpty()) {
        State.Success(this)
    } else {
        State.Loading
    }
}