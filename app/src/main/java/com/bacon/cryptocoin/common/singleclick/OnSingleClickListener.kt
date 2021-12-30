package com.bacon.cryptocoin.common.singleclick

import android.view.View

class OnSingleClickListener : View.OnFocusChangeListener, View.OnClickListener {

    private lateinit var onClickListener: View.OnClickListener

    private var onFocusChangeListener: View.OnFocusChangeListener

    constructor(listener: View.OnFocusChangeListener) {
        onFocusChangeListener = listener
    }

    constructor(listener: (View) -> Unit) {
        onFocusChangeListener = View.OnFocusChangeListener { it, hasFocus ->
            if (hasFocus) {
                listener.invoke(it)
            }
        }
        onClickListener = View.OnClickListener { listener.invoke(it) }
    }


    override fun onFocusChange(v: View?, h: Boolean) {
        val currentTimeMillis = System.currentTimeMillis()

        if (currentTimeMillis >= previousClickTimeMillis + DELAY_MILLIS) {
            previousClickTimeMillis = currentTimeMillis
            onFocusChangeListener.onFocusChange(v, h)
        }
    }

    override fun onClick(v: View?) {
        val currentTimeMillis = System.currentTimeMillis()

        if (currentTimeMillis >= previousClickTimeMillis + DELAY_MILLIS) {
            previousClickTimeMillis = currentTimeMillis
            onClickListener.onClick(v)
        }
    }

    companion object {
        private const val DELAY_MILLIS = 200L
        private var previousClickTimeMillis = 0L
    }

}