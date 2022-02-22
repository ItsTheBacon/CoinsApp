package com.bacon.cryptocoin.data.remote.apiservices

import com.bacon.cryptocoin.data.remote.dtos.CoinDetailDto
import com.bacon.cryptocoin.data.remote.dtos.CoinsItemDto
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinDetailApiService {
    @GET("markets")
    suspend fun fetchCoinDetail(
        @Query("coinId") id: String,
    ): List<CoinDetailDto>

}