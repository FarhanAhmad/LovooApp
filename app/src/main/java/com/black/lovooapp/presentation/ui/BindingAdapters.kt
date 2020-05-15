package com.black.lovooapp.presentation.ui

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.black.lovooapp.presentation.LovooRoom

/**
 * Created by farhanahmad on 16/5/20.
 */

@BindingAdapter("app:items")
fun setRVItems(rv: RecyclerView, list: List<LovooRoom>?) {
    if (rv.adapter is RoomListAdapter)
        (rv.adapter as RoomListAdapter).submitList(list?.toList() ?: emptyList())
}