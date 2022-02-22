package com.bacon.cryptocoin.presentation.models

import com.bacon.cryptocoin.domain.models.CoinDetailModel

data class CoinDetailUI(
    val volume: Double? = null,
    val price: Double? = null,
    val pairPrice: Double? = null,
    val exchange: String? = null,
    val pair: String? = null,
)

fun CoinDetailModel.toUI() = CoinDetailUI(volume, price, pairPrice, exchange, pair)