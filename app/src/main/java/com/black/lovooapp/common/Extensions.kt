package com.black.lovooapp.common

import com.black.lovooapp.domain.model.LovooRoomDTO
import com.black.lovooapp.presentation.LovooRoom

/**
 * Created by farhanahmad on 16/5/20.
 */

fun LovooRoomDTO.toLovooRoom(): LovooRoom {
    return LovooRoom(id ?: "", name ?: "", department ?: "", type ?: "")
}