package com.bacon.cryptocoin.presentation.models

import com.bacon.cryptocoin.common.base.IBaseDiffModel
import com.bacon.cryptocoin.domain.models.CoinsItemModel

data class CoinsItemUI(
    val symbol: String? = null,
    val marketCap: Double ? = null,
    val priceChangeW: Double ? = null,
    val availableSupply: Double ? = null,
    val totalSupply: Double ? = null,
    val twitterUrl: String ? = null,
    val icon: String ? = null,
    val priceChangeH: Double ? = null,
    val priceBtc: Double ? = null,
    val volume: Double ? = null,
    val priceChangeD: Double ? = null,
    val websiteUrl: String ? = null,
    val price: Double ? = null,
    val name: String ? = null,
    val rank: Double ? = null,
    override val id: String ? = null,
    val exp: List<String>? = null,
) : IBaseDiffModel

fun CoinsItemModel.toUI() = CoinsItemUI(symbol,
    marketCap,
    priceChangeW,
    availableSupply,
    totalSupply,
    twitterUrl,
    icon,
    priceChangeH,
    priceBtc,
    volume,
    priceChangeD,
    websiteUrl,
    price,
    name,
    rank,
    id,
    exp)