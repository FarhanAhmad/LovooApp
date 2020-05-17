package com.black.lovooapp.presentation.ui.roomdetail

import androidx.databinding.ViewDataBinding
import com.black.lovooapp.databinding.ItemRoomBookingBinding
import com.black.lovooapp.presentation.model.LovooRoomBookings
import com.black.lovooapp.presentation.ui.BaseViewHolder

/**
 * Created by farhanahmad on 18/5/20.
 */
class RoomBookingItemViewHolder(val viewDataBinding: ViewDataBinding) :
        BaseViewHolder(viewDataBinding.root) {
    override fun doBind(obj: Any) {
        if (viewDataBinding !is ItemRoomBookingBinding || obj !is LovooRoomBookings)
            return

        viewDataBinding.obj = obj
        viewDataBinding.executePendingBindings()
    }
}