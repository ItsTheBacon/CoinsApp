package com.bacon.cryptocoin.data.remote.dtos

data class CoinsTradingResponseDto<T>(
    val coins: List<T>,
)

fun <T> CoinsTradingResponseDto<T>.toDomain() = CoinsTradingResponseDto(coins)