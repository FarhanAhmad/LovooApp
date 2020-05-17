package com.black.lovooapp.presentation.ui.roomdetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.black.lovooapp.databinding.ItemRoomFactImageBinding
import com.black.lovooapp.presentation.ui.BaseViewHolder

/**
 * Created by farhanahmad on 17/5/20.
 */
class RoomImagesAdapter(val imageList: List<String>) : RecyclerView.Adapter<BaseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val binding = ItemRoomFactImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return RoomImageItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.doBind(imageList[position])
    }
}