package com.bacon.cryptocoin.data.repositories

import com.bacon.cryptocoin.common.base.BaseRepository
import com.bacon.cryptocoin.data.remote.apiservices.CoinsApiService
import com.bacon.cryptocoin.data.remote.dtos.toDomain
import com.bacon.cryptocoin.domain.repositories.CoinsRepository
import javax.inject.Inject

class CoinsRepositoryImpl @Inject constructor(
    private val service: CoinsApiService,
) : BaseRepository(), CoinsRepository {


    override fun fetchCoins() = doRequest {
        service.fetchCoins().coins.map {
            it.toDomain()
        }
    }

}