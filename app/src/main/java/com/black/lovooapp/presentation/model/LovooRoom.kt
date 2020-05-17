package com.black.lovooapp.presentation.model

import android.os.Parcelable
import com.black.lovooapp.common.BaseModel
import kotlinx.android.parcel.Parcelize

/**
 * Created by farhanahmad on 14/5/20.
 */
@Parcelize
data class LovooRoom(val id: String, val name: String, val department: String, val type: String, val roomFact: LovooRoomFact? = null) :
        BaseModel(), Parcelable {

    override fun isValid(): Boolean {
        return true
    }
}