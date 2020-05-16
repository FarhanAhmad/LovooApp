package com.black.lovooapp.presentation.viewmodel

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.black.lovooapp.domain.IAppRepository
import com.black.lovooapp.domain.usecase.GetRoomsUseCase
import com.black.lovooapp.presentation.LovooRoom
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by farhanahmad on 15/5/20.
 */
class RoomsListViewModel(private val appRepository: IAppRepository) : ViewModel() {

    val isLoading = ObservableBoolean(false)

    val roomList = ObservableArrayList<LovooRoom>()

    init {
        /**
         * View model initiated. Lets fetch the data
         */

        loadData()
    }

    private fun loadData() {
        isLoading.set(true)

        viewModelScope.launch(Dispatchers.IO) {
            val getRoomsUseCase = GetRoomsUseCase(appRepository)

            val list = getRoomsUseCase.execute()

            launch(Dispatchers.Main) {
                roomList.clear()
                roomList.addAll(list)
            }

            isLoading.set(false)
        }

    }
}