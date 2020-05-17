package com.black.lovooapp.presentation.ui.roomdetail

import androidx.databinding.ViewDataBinding
import com.black.lovooapp.databinding.ItemRoomFactImageBinding
import com.black.lovooapp.presentation.ui.BaseViewHolder

class RoomImageItemViewHolder(private val viewDataBinding: ViewDataBinding) :
        BaseViewHolder(viewDataBinding.root) {

    override fun doBind(obj: Any) {
        if (obj !is String || viewDataBinding !is ItemRoomFactImageBinding)
            return

        viewDataBinding.imageUrl = obj

        viewDataBinding.executePendingBindings()

    }

}
