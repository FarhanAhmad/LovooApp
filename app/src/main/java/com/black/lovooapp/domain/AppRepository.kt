package com.black.lovooapp.domain

import com.black.lovooapp.domain.data.remote.INetworkSource
import com.black.lovooapp.presentation.LovooRoom

/**
 * Created by farhanahmad on 14/5/20.
 */
class AppRepository(private val remoteSource: INetworkSource) : IAppRepository {

    override suspend fun getRooms(): List<LovooRoom> {

        return remoteSource.getRooms().mapNotNull {
            if (it.isValid())
                LovooRoom(it.id ?: "")
            else null
        }
    }
}