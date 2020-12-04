package com.example.myyoutube

import android.content.Context
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

fun ImageView.loadImage(url: String, placeholder: Int = 0){
    Glide.with(this.context)
        .load(url)
        .placeholder(placeholder)
        .into(this)
}
fun Context.showToastShort(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
fun YouTubePlayerView.layoutParams(run: ViewGroup.LayoutParams.() -> Unit) {
    val params=layoutParams
    run (params)
    layoutParams=params
}
