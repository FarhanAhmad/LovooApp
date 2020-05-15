package com.black.lovooapp.presentation

import com.black.lovooapp.common.BaseModel

/**
 * Created by farhanahmad on 14/5/20.
 */
data class LovooRoom(val id: String, val name: String, val department: String, val type: String) :
        BaseModel() {

    override fun isValid(): Boolean {
        return true
    }
}