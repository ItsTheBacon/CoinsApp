package com.bacon.cryptocoin.common.base

interface IBaseDiffModel {
    val id: String?
    override fun equals(other: Any?): Boolean
}