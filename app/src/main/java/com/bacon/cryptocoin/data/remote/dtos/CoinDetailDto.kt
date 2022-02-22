package com.bacon.cryptocoin.data.remote.dtos

import com.bacon.cryptocoin.domain.models.CoinDetailModel

data class CoinDetailDto(
    val volume: Double? = null,
    val price: Double? = null,
    val pairPrice: Double? = null,
    val exchange: String? = null,
    val pair: String? = null,
)

fun CoinDetailDto.toDomain() = CoinDetailModel(volume, price, pairPrice, exchange, pair)