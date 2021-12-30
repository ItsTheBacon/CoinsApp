package com.bacon.cryptocoin.data.remote.dtos

import com.google.gson.annotations.SerializedName

data class CoinsResponseDto<T>(
    @SerializedName("data")
    val data: List<T>,
    @SerializedName("timestamp")
    val timestamp: Long = 0
)


