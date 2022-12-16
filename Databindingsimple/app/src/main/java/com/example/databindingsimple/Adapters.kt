package com.example.databindingsimple

import android.widget.ImageView
import androidx.annotation.VisibleForTesting
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide



@BindingAdapter("ImagefromUrl")
fun ImageView.ImagefromUrl(url: String)

{
    Glide.with(context)
        .load(url)
        .into(this)

}