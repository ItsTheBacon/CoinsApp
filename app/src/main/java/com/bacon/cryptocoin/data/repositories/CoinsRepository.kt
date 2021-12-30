package com.bacon.cryptocoin.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.bacon.cryptocoin.common.base.BaseRepository
import com.bacon.cryptocoin.data.remote.apiservices.CoinsApiService
import com.bacon.cryptocoin.data.remote.dtos.CoinsDto
import com.bacon.cryptocoin.data.remote.pagingsources.CoinsPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CoinsRepository @Inject constructor(
    private val service: CoinsApiService
) : BaseRepository() {


    fun fetchCoins(): Flow<PagingData<CoinsDto>> {
        return Pager(config =
        PagingConfig(pageSize = 50, enablePlaceholders = false),
            pagingSourceFactory = {
                CoinsPagingSource(service)
            }
        ).flow
    }

}