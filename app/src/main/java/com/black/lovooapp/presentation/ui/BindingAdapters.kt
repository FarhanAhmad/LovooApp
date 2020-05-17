package com.black.lovooapp.presentation.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.black.lovooapp.presentation.model.LovooRoom
import com.black.lovooapp.presentation.ui.roomlist.RoomListAdapter
import com.bumptech.glide.Glide

/**
 * Created by farhanahmad on 16/5/20.
 */

@BindingAdapter("app:items")
fun setRVItems(rv: RecyclerView, list: List<LovooRoom>?) {
    if (rv.adapter is RoomListAdapter)
        (rv.adapter as RoomListAdapter).submitList(list?.toList() ?: emptyList())
}

@BindingAdapter("app:imageUrl")
fun setImageUrl(iv: ImageView, imageUrl: String) {
    Glide.with(iv.context).load(imageUrl).into(iv)
}