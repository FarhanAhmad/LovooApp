package com.black.lovooapp.presentation.ui

import androidx.recyclerview.widget.RecyclerView

/**
 * Created by farhanahmad on 18/5/20.
 */
abstract class BaseArrayAdapter(val list: List<Any>) : RecyclerView.Adapter<BaseViewHolder>() {

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.doBind(list[position])
    }
}