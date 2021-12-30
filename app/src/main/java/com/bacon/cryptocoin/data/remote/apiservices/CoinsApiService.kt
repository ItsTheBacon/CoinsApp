package com.bacon.cryptocoin.data.remote.apiservices

import com.bacon.cryptocoin.data.remote.dtos.CoinsDto
import com.bacon.cryptocoin.data.remote.dtos.CoinsResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinsApiService {
    @GET("v2/assets/")
    suspend fun fetchCoins(@Query("offset") start: Int?, @Query("limit") limit: Int?) : CoinsResponseDto<CoinsDto>
}