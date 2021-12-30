package com.bacon.cryptocoin.data.repositories

import com.bacon.cryptocoin.common.base.BaseRepository
import com.bacon.cryptocoin.data.remote.apiservices.CoinDetailApiService
import javax.inject.Inject

class CoinsDetailRepository @Inject constructor(
    private val service: CoinDetailApiService
) : BaseRepository() {

    fun fetchCoinDetail(id:String) = doRequest {
        service.fetchCoinDetail(id)
    }
}