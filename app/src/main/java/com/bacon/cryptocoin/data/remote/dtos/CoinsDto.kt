package com.bacon.cryptocoin.data.remote.dtos

import com.bacon.cryptocoin.common.base.IBaseDiffModel

data class CoinsDto(
    val symbol: String = "",
    val volumeUsdHr: String = "",
    val marketCapUsd: String = "",
    val priceUsd: String = "",
    val vwapHr: String = "",
    val changePercentHr: String = "",
    val name: String = "",
    val explorer: String = "",
    val rank: String = "",
    override val id: String = "",
    val supply: String = ""
): IBaseDiffModel

