package com.black.lovooapp.domain.data.local

import com.black.lovooapp.domain.db.AppDao
import com.black.lovooapp.domain.db.RoomBookingEntity

/**
 * Created by farhanahmad on 18/5/20.
 */
class LocalDataSource(val appDao: AppDao) : ILocalSource {
    override suspend fun getRoomBookings(roomId: String): List<RoomBookingEntity> {
        return appDao.getBookings(roomId)
    }

    override suspend fun bookRoom(roomBooking: RoomBookingEntity) {
        appDao.insertBooking(roomBooking)
    }
}