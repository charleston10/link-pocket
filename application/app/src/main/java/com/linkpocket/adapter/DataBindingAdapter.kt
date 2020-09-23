package com.linkpocket.adapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.linkpocket.R

object DataBindingAdapter {

    @JvmStatic
    @BindingAdapter("bind:textDescription")
    fun bindDescription(textView: TextView, textDescription: String) {
        textView.text = "Description:$textDescription"
    }

    @JvmStatic
    @BindingAdapter("bind:imageURL")
    fun bindImageURL(imageView: ImageView, url: String) {
        Glide.with(imageView.context)
            .load(url)
            .placeholder(R.drawable.ic_launcher_background)
            .into(imageView)
    }
}