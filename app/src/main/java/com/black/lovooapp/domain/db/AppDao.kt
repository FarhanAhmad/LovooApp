package com.black.lovooapp.domain.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

/**
 * Created by farhanahmad on 17/5/20.
 */
@Dao
interface AppDao {

    @Query("Select * from bookings where roomNumber=:roomNumber")
    suspend fun getBookings(roomNumber: String):List<RoomBookingEntity>

    @Insert
    suspend fun insertBooking(entity: RoomBookingEntity)
}