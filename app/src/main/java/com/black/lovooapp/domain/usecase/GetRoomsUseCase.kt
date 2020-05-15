package com.black.lovooapp.domain.usecase

import com.black.lovooapp.domain.IAppRepository
import com.black.lovooapp.presentation.LovooRoom

/**
 * Created by farhanahmad on 15/5/20.
 *
 * Fetches rooms from backend.
 * Can be reused.
 * Can have more functionality. At the moment, It just downloads the rooms
 */
class GetRoomsUseCase(private val repo: IAppRepository) : BaseUseCase() {

    override suspend fun execute(): List<LovooRoom> {
        return repo.getRooms()
    }
}