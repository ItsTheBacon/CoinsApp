package com.bacon.cryptocoin.domain.models

data class CoinDetailModel(
    val volume: Double? = null,
    val price: Double? = null,
    val pairPrice: Double? = null,
    val exchange: String? = null,
    val pair: String? = null,
)