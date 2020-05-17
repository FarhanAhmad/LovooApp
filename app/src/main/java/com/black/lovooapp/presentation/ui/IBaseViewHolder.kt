package com.black.lovooapp.presentation.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by farhanahmad on 17/5/20.
 */
abstract class BaseViewHolder(val view: View):RecyclerView.ViewHolder(view) {

    abstract fun doBind(obj:Any)
}