package com.bacon.cryptocoin.common.extensions

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

fun ImageView.loadImage(url: String, progressBar: ProgressBar, placeholder: Int = 0) {
    Glide.with(this.context)
        .load(url)
        .placeholder(placeholder)
        .listener(object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean,
            ): Boolean {
                progressBar.visibility = View.GONE
                return false
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean,
            ): Boolean {
                progressBar.visibility = View.GONE
                return false
            }
        })
        .into(this)
}


fun ImageView.loadLogo(url: String, placeHolder: Int = 0) {
    Glide.with(this.context)
        .load(url)
        .error(placeHolder)
        .into(this)
}

fun ImageView.loadAvatar(url: String, placeholder: Int = 0) {
    Glide.with(this.context)
        .load(url)
        .circleCrop()
        .error(placeholder)
        .into(this)
}

