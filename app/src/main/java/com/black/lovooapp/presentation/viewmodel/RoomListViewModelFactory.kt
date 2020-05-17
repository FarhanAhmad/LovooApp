package com.black.lovooapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.black.lovooapp.domain.IAppRepository

/**
 * Created by farhanahmad on 16/5/20.
 */
class RoomListViewModelFactory(private val appRepository: IAppRepository) :
        ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RoomsListViewModel::class.java))
            return RoomsListViewModel(appRepository) as T
        else
            throw IllegalStateException()
    }

}