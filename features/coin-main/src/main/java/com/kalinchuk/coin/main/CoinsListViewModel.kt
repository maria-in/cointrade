package com.kalinchuk.coin.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kalinchuk.coin.data.RequestResult
import com.kalinchuk.coin.data.models.Coin
import com.kalinchuk.coin.main.usecases.GetCoinsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject
import javax.inject.Provider

@HiltViewModel
internal class CoinsListViewModel @Inject constructor(
    getCoinsListUseCase: Provider<GetCoinsListUseCase>
) : ViewModel() {

    val state: SharedFlow<State> =
        getCoinsListUseCase.get().invoke()
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