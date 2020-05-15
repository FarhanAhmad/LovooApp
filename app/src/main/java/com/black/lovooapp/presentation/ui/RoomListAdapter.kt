package com.black.lovooapp.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.black.lovooapp.databinding.ItemRoomListBinding
import com.black.lovooapp.presentation.LovooRoom

class RoomListAdapter : ListAdapter<LovooRoom, RoomListItemViewHolder>(DIFF_CALLBACK) {

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<LovooRoom>() {
            override fun areItemsTheSame(oldItem: LovooRoom, newItem: LovooRoom): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: LovooRoom, newItem: LovooRoom): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomListItemViewHolder {
        return RoomListItemViewHolder(
                ItemRoomListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                                     )
    }

    override fun onBindViewHolder(holder: RoomListItemViewHolder, position: Int) {
        holder.doBind(getItem(position))
    }

}
