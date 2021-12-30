package com.bacon.cryptocoin.common.extensions

import kotlin.math.ln
import kotlin.math.pow

fun getFormatNumber(count: Long): String {
    if (count < 1000) return "" + count
    val exp = (ln(count.toDouble()) / ln(1000.0)).toInt()
    return String.format("%.1f %c", count / 1000.0.pow(exp.toDouble()), "kMGTPE"[exp - 1])
}