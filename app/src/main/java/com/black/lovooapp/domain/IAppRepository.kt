package com.black.lovooapp.domain

import com.black.lovooapp.presentation.model.LovooRoom
import com.black.lovooapp.presentation.model.LovooRoomBookings

/**
 * Created by farhanahmad on 14/5/20.
 */
interface IAppRepository {

    suspend fun getRooms():List<LovooRoom>

    suspend fun getRoomBookings(roomNumber:String):List<LovooRoomBookings>

    suspend fun bookRoom(roomNumber:String,date:String,startTime:String,endTime:String)
}