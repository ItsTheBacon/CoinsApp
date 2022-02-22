package com.bacon.cryptocoin.domain.usecases

import com.bacon.cryptocoin.domain.repositories.CoinsDetailRepository
import javax.inject.Inject

class FetchCoinDetailUseCase @Inject constructor(
    private val repository: CoinsDetailRepository,
) {

    operator fun invoke(coinId: String) = repository.fetchCoinDetail(coinId)
}