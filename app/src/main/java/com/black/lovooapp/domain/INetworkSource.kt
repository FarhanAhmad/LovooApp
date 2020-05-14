package com.black.lovooapp.domain

import com.black.lovooapp.domain.model.LovooRoomDTO

/**
 * Created by farhanahmad on 14/5/20.
 */
interface INetworkSource {

    suspend fun getRooms():List<LovooRoomDTO>
}