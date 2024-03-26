package com.kalinchuk.coin.main

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kalinchuk.coin.data.models.Coin


@Composable
fun CoinsListScreen() {
    CoinsListScreen(viewModel = viewModel())
}

@Composable
internal fun CoinsListScreen(viewModel: CoinsListViewModel) {

    val status = viewModel.status.collectAsState(initial = "")
    when (val currentState = status.value) {
        "" -> Log.println(Log.ERROR, "QQQQQQQQ", "false")
        else -> Log.println(Log.ERROR, "QQQQQQQQ", currentState)
    }

//    val state by viewModel.state.collectAsState(initial = State.None)
//    when (val currentState = state) {
//        is State.Success -> drawContent(currentState.coins)
//        is State.Loading -> { Log.println(Log.ERROR, "TTTTT", "Loading") }//TODO()
//        is State.Error -> { Log.println(Log.ERROR, "TTTTT", "Error") }//TODO()
//        State.None -> { Log.println(Log.ERROR, "TTTTT", "None") }//TODO()
//    }
}

@Composable
private fun drawContent(coins: List<Coin>) {
    LazyColumn {
        items(coins) { coin ->
            key(coin.id) {
                Coin(coin)
            }
        }
    }
}

//TODO: add preview
@Composable
private fun Coin(coin: Coin) {

    val imageModifier = Modifier
        .size(150.dp)
        .border(BorderStroke(1.dp, Color.Green))

    Row(modifier = Modifier.padding(8.dp)) {
        Image(
            painter = painterResource(id = androidx.core.R.drawable.ic_call_answer),
            contentDescription = coin.symbol,
            modifier = imageModifier
        )

        Column {
            Text(text = coin.name)
            Text(text = coin.symbol)
        }

        Column {
            Text(text = coin.currentPrice.toString())
            Text(text = "${coin.priceChangePercentagePerDay} %")
        }
    }
}