package com.black.lovooapp.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by farhanahmad on 17/5/20.
 */
@Parcelize
data class LovooRoomFact(val title: String, val text: String, val imageList: List<String>) :
        Parcelable