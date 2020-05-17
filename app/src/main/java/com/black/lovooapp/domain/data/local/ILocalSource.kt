package com.black.lovooapp.domain.data.local

import com.black.lovooapp.domain.db.RoomBookingEntity

/**
 * Created by farhanahmad on 18/5/20.
 */
interface ILocalSource {

    suspend fun getRoomBookings(roomId:String):List<RoomBookingEntity>

    suspend fun bookRoom(roomBooking:RoomBookingEntity)
}