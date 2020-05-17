package com.black.lovooapp.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.black.lovooapp.domain.IAppRepository
import com.black.lovooapp.presentation.model.LovooRoom
import com.black.lovooapp.presentation.model.LovooRoomBookings
import com.black.lovooapp.presentation.model.LovooRoomFact
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by farhanahmad on 18/5/20.
 */
class RoomDetailViewModel(val appRepository: IAppRepository) : ViewModel() {

    var lovooRoom: LovooRoom? = null

    val lovooRoomFact = MutableLiveData<LovooRoomFact>()
    val lovooRoomBookings = MutableLiveData<List<LovooRoomBookings>>()

    fun setRoomData(roomObj: LovooRoom?) {
        lovooRoom = roomObj

        loadData()
    }

    private fun loadData() {

        if (lovooRoom?.roomFact != null)
            lovooRoomFact.postValue(lovooRoom?.roomFact)

        findRoomBookings()

    }

    private fun findRoomBookings() {
        if (lovooRoom?.type != "meeting")
            return

        viewModelScope.launch(Dispatchers.IO) {
            val list = appRepository.getRoomBookings(lovooRoom?.roomNumber ?: "")
            lovooRoomBookings.postValue(list)
        }

    }

    fun bookRoom() {
        //TODO: Just adding a temporary data. Ignoring the checks

        viewModelScope.launch(Dispatchers.IO) {
            appRepository.bookRoom(lovooRoom?.roomNumber ?: "", "", "", "")

            //reload bookings to reflect on UI
            findRoomBookings()
        }
    }
}