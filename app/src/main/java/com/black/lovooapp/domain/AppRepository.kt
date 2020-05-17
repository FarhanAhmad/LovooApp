package com.black.lovooapp.domain

import com.black.lovooapp.common.toLovooRoom
import com.black.lovooapp.domain.data.remote.INetworkSource
import com.black.lovooapp.presentation.model.LovooRoom

/**
 * Created by farhanahmad on 14/5/20.
 */
class AppRepository(private val remoteSource: INetworkSource) : IAppRepository {

    override suspend fun getRooms(): List<LovooRoom> {

        /**
         * Can have more functionality here, Like persisting the data also. or loading from cache.
         * All of getting rooms logic will be added here, incase we need it in future.
         */

        return remoteSource.getRooms().mapNotNull {
            if (it.isValid())
                it.toLovooRoom()
            else null
        }
    }
}