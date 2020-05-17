package com.black.lovooapp.domain

import com.black.lovooapp.domain.data.remote.INetworkSource
import com.black.lovooapp.domain.data.remote.NetworkDataSourceImpl
import com.black.lovooapp.domain.model.LovooRoomDTO
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

/**
 * Created by farhanahmad on 14/5/20.
 */
class NetworkDataSourceImplTest {

    lateinit var networkSource: INetworkSource

    val tempList:List<LovooRoomDTO> = arrayListOf()

    @Before
    fun setup() {
        networkSource = Mockito.mock(NetworkDataSourceImpl::class.java)

    }

    @Test
    fun testGetRoomsFromNetwork() = runBlockingTest {

        Mockito.`when`(networkSource.getRooms()).thenReturn(tempList)

        val list = networkSource.getRooms()

        assert(list != null)

    }

}