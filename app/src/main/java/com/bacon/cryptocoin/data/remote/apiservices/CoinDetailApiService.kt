package com.bacon.cryptocoin.data.remote.apiservices

import com.bacon.cryptocoin.data.remote.dtos.CoinsDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinDetailApiService {
    @GET("v2/assets/{id}/")
    suspend fun fetchCoinDetail(
        @Path("id") id: String
    ): CoinsDto

}