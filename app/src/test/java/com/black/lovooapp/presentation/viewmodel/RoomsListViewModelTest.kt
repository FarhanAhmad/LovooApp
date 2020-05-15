package com.black.lovooapp.presentation.viewmodel

import com.black.lovooapp.domain.AppRepository
import com.black.lovooapp.domain.IAppRepository
import com.black.lovooapp.presentation.LovooRoom
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mockito

/**
 * Created by farhanahmad on 15/5/20.
 */
class RoomsListViewModelTest {

    lateinit var appRepository:IAppRepository
    lateinit var viewModel: RoomsListViewModel

    val mockRoomList = arrayListOf<LovooRoom>()


    @Before
    fun setUp() {

        appRepository = Mockito.mock(AppRepository::class.java)

        mockRoomList.clear()
        mockRoomList.add(LovooRoom("123","","",""))

    }

    @After
    fun tearDown() {
    }

    @Test
    fun testViewModelLoadData(){
        

    }

}