package com.harnet69.letsexploreit.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.harnet69.letsexploreit.R


//extension for auto loading image of ImageView element using Glide library
fun ImageView.loadImage(uri: String?) {
    val options = RequestOptions()
        .placeholder(R.drawable.ic_launcher_foreground)
    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(uri)
        .into(this)// this - extended ImageView class
}

// load image by ViewBinding(uses extended load function to bind this function to imageView)
// @BindingAdapter annotation make function visible from a layout (parameter fill be the name of xml field)
// !!!REBUILD PROJECT AFTER IMPLEMENTING!!!
@BindingAdapter("android:bindImageUrl")
fun loadBindingImage(view: ImageView, url: String?) {
    view.loadImage(url)
}