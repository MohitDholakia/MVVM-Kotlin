package com.md.demo.misc.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_detail.*

object BindingUtils {
    @BindingAdapter("image")
    fun ImageView.setGlideImage(res: String) {
        Glide.with(this)
                .load(res)
                .into(this)
    }
}