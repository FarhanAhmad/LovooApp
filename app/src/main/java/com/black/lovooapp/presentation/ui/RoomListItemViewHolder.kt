package com.black.lovooapp.presentation.ui

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.black.lovooapp.databinding.ItemRoomListBinding
import com.black.lovooapp.presentation.LovooRoom

class RoomListItemViewHolder(val viewBinding: ViewDataBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

    fun doBind(item: LovooRoom) {
        if (viewBinding is ItemRoomListBinding) {
            viewBinding.obj = item
            viewBinding.executePendingBindings()
        }
    }

}
