package com.kalinchuk.coin.main.utils

import com.kalinchuk.coin.uikit.R

enum class Currency(
    private val type: Int,
    private val abbreviation: String,
    private val sign: String
) {
    USD(R.string.united_states_dollar, "usd", "$"),
    EUR(R.string.euro, "eur", "€"),
    GBP(R.string.british_pound_sterling, "gbp", "£"),
    JPY(R.string.japanese_yen, "jpy", "¥"),
    CAD(R.string.canadian_dollar, "cad", "$"),
    AUD(R.string.australian_dollar, "aud", "$");

    fun getSignByAbbreviation(): String = this.sign
}