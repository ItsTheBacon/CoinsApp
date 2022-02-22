package com.bacon.cryptocoin.data.remote.apiservices

import com.bacon.cryptocoin.data.remote.dtos.CoinsItemDto
import com.bacon.cryptocoin.data.remote.dtos.CoinsTradingResponseDto
import retrofit2.http.GET

interface CoinsApiService {
    @GET("coins?skip=0&limit=30")
    suspend fun fetchCoins(): CoinsTradingResponseDto<CoinsItemDto>
}