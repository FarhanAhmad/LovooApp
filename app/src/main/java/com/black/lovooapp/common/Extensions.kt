package com.black.lovooapp.common

import com.black.lovooapp.domain.model.LovooFactDTO
import com.black.lovooapp.domain.model.LovooRoomDTO
import com.black.lovooapp.presentation.model.LovooRoom
import com.black.lovooapp.presentation.model.LovooRoomFact

/**
 * Created by farhanahmad on 16/5/20.
 */

fun LovooRoomDTO.toLovooRoom(): LovooRoom {
    return LovooRoom(id ?: "", name
            ?: "", department ?: "", type ?: "", lovooFact?.toLovooFact())
}

fun LovooFactDTO?.toLovooFact(): LovooRoomFact? {
    if (this == null)
        return null

    return LovooRoomFact(title ?: "", text ?: "", images ?: emptyList())
}