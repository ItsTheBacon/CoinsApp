package com.bacon.cryptocoin.domain.models

data class CoinsTradingResponseModel<T>(
    val coins: List<T>?,
)