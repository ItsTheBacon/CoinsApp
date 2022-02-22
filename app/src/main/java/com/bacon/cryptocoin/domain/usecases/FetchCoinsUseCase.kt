package com.bacon.cryptocoin.domain.usecases

import com.bacon.cryptocoin.domain.repositories.CoinsRepository
import javax.inject.Inject

class FetchCoinsUseCase @Inject constructor(
    private val repository: CoinsRepository,
) {
    operator fun invoke() = repository.fetchCoins()
}