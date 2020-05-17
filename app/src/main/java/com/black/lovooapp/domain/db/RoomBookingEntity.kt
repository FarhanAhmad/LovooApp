package com.black.lovooapp.domain.db

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by farhanahmad on 17/5/20.
 */
@Entity(tableName = "bookings")
data class RoomBookingEntity(
        @PrimaryKey(autoGenerate = true)
        val id: Int = 0,
        val roomNumber: String,
        val bookingStartTime: Long,
        val bookingEndTime: Long
                            ) {

    companion object {
        fun createTempObj(rNumber: String): RoomBookingEntity {

            return RoomBookingEntity(roomNumber = rNumber, bookingStartTime = System.currentTimeMillis(), bookingEndTime = System.currentTimeMillis() + 30 * 60 * 1000)
        }
    }
}

