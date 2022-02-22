package com.bacon.cryptocoin.data.repositories

import com.bacon.cryptocoin.common.base.BaseRepository
import com.bacon.cryptocoin.data.remote.apiservices.CoinDetailApiService
import com.bacon.cryptocoin.data.remote.dtos.toDomain
import com.bacon.cryptocoin.domain.repositories.CoinsDetailRepository
import javax.inject.Inject

class CoinsDetailRepositoryImpl @Inject constructor(
    private val service: CoinDetailApiService,
) : BaseRepository(), CoinsDetailRepository {
    override fun fetchCoinDetail(coinId: String) = doRequest {
        service.fetchCoinDetail(coinId).map {
            it.toDomain()
        }
    }
}