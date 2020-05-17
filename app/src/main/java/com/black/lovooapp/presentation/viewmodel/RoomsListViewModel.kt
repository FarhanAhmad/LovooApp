package com.black.lovooapp.presentation.viewmodel

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.black.lovooapp.domain.IAppRepository
import com.black.lovooapp.domain.usecase.GetRoomsUseCase
import com.black.lovooapp.presentation.model.LovooRoom
import com.black.lovooapp.presentation.ui.FilterType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by farhanahmad on 15/5/20.
 */
class RoomsListViewModel(private val appRepository: IAppRepository) : ViewModel() {

    val isLoading = ObservableBoolean(false)

    val roomList = arrayListOf<LovooRoom>()

    val filteredList = ObservableArrayList<LovooRoom>()

    val roomTypes = MutableLiveData<Array<String>>()
    val roomDepartments = MutableLiveData<Array<String>>()

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

            launch {
                populateRoomTypes(list)
            }
            launch {
                populateRoomDepartments(list)
            }

            launch(Dispatchers.Main) {
                roomList.clear()
                filteredList.clear()

                roomList.addAll(list)
                filteredList.addAll(list)
            }

            isLoading.set(false)
        }
    }

    private fun populateRoomTypes(list: List<LovooRoom>) {
        val set = HashSet<String>()
        set.add("--")

        list.map {
            if (!it.type.isNullOrBlank())
                set.add(it.type)
        }

        roomTypes.postValue(set.toTypedArray())
    }

    private fun populateRoomDepartments(list: List<LovooRoom>) {
        val set = HashSet<String>()
        set.add("--")

        list.map {
            if (!it.department.isNullOrBlank())
                set.add(it.department)
        }

        roomDepartments.postValue(set.toTypedArray())
    }

    fun clearFilters() {
        filteredList.clear()
        filteredList.addAll(roomList)
    }

    fun applyFilter(filterType: FilterType, filter: String) {

        if (filter == "--") {
            clearFilters()
        } else {
            filteredList.clear()
            filteredList.addAll(roomList.filter {
                when (filterType) {
                    FilterType.RoomDepartment -> {
                        it.department == filter
                    }
                    else -> {
                        it.type == filter
                    }
                }
            })
        }
    }

}