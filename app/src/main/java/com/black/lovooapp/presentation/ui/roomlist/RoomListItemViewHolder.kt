package com.black.lovooapp.presentation.ui.roomlist

import androidx.databinding.ViewDataBinding
import com.black.lovooapp.databinding.ItemRoomListBinding
import com.black.lovooapp.presentation.model.LovooRoom
import com.black.lovooapp.presentation.ui.BaseViewHolder

class RoomListItemViewHolder(private val clickListener: IRoomClickListener? = null, private val viewBinding: ViewDataBinding) :
        BaseViewHolder(viewBinding.root) {

    override fun doBind(obj: Any) {
        if (obj !is LovooRoom)
            return

        if (viewBinding is ItemRoomListBinding) {
            viewBinding.obj = obj
            viewBinding.executePendingBindings()
        }
        viewBinding.root.setOnClickListener {
            if(obj.roomFact != null)
                clickListener?.onRoomClick(obj)
        }
    }

}
