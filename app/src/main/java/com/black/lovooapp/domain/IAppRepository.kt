package com.black.lovooapp.domain

import com.black.lovooapp.presentation.LovooRoom

/**
 * Created by farhanahmad on 14/5/20.
 */
interface IAppRepository {

    suspend fun getRooms():List<LovooRoom>
}