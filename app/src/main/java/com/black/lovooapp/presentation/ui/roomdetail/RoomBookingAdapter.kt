package com.black.lovooapp.presentation.ui.roomdetail

import android.view.LayoutInflater
import android.view.ViewGroup
import com.black.lovooapp.databinding.ItemRoomBookingBinding
import com.black.lovooapp.presentation.model.LovooRoomBookings
import com.black.lovooapp.presentation.ui.BaseArrayAdapter
import com.black.lovooapp.presentation.ui.BaseViewHolder

class RoomBookingAdapter(list: List<LovooRoomBookings>) :
        BaseArrayAdapter(list) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val binding = ItemRoomBookingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RoomBookingItemViewHolder(binding)
    }

}
