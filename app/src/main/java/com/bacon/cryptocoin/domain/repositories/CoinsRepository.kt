package com.bacon.cryptocoin.domain.repositories

import com.bacon.cryptocoin.common.resources.Resource
import com.bacon.cryptocoin.domain.models.CoinsItemModel
import kotlinx.coroutines.flow.Flow

interface CoinsRepository {
    fun fetchCoins(): Flow<Resource<List<CoinsItemModel>>>
}