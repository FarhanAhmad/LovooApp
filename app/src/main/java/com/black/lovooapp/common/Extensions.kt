package com.black.lovooapp.common

import com.black.lovooapp.domain.db.RoomBookingEntity
import com.black.lovooapp.domain.model.LovooFactDTO
import com.black.lovooapp.domain.model.LovooRoomDTO
import com.black.lovooapp.presentation.model.LovooRoom
import com.black.lovooapp.presentation.model.LovooRoomBookings
import com.black.lovooapp.presentation.model.LovooRoomFact
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by farhanahmad on 16/5/20.
 */

fun LovooRoomDTO.toLovooRoom(): LovooRoom {
    return LovooRoom(id ?: "", name
            ?: "", department ?: "", type ?: "", lovooFact?.toLovooFact(), roomNumber ?: "")
}

fun LovooFactDTO?.toLovooFact(): LovooRoomFact? {
    if (this == null)
        return null

    return LovooRoomFact(title ?: "", text ?: "", images ?: emptyList())
}

fun RoomBookingEntity.toLovooRoomBooking(): LovooRoomBookings {
    val cal = Calendar.getInstance()
    cal.timeInMillis = bookingStartTime
    val bStartTime = SimpleDateFormat("HH:mm").format(cal.time)

    cal.timeInMillis = bookingEndTime

    val bEndTime = SimpleDateFormat("HH:mm").format(cal.time)
    val date = SimpleDateFormat("dd/MM/yyy").format(cal.time)

    return LovooRoomBookings(date, bStartTime, bEndTime)
}