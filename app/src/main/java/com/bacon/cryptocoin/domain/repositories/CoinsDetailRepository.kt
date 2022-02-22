package com.bacon.cryptocoin.domain.repositories

import com.bacon.cryptocoin.common.resources.Resource
import com.bacon.cryptocoin.domain.models.CoinDetailModel
import com.bacon.cryptocoin.domain.models.CoinsItemModel
import kotlinx.coroutines.flow.Flow

interface CoinsDetailRepository {
    fun fetchCoinDetail(coinId: String): Flow<Resource<List<CoinDetailModel>>>

}