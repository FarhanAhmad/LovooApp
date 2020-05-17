package com.black.lovooapp.domain

import com.black.lovooapp.domain.data.local.ILocalSource
import com.black.lovooapp.domain.data.local.LocalDataSource
import com.black.lovooapp.domain.data.remote.INetworkSource
import com.black.lovooapp.domain.data.remote.NetworkDataSourceImpl
import com.black.lovooapp.domain.model.LovooRoomDTO
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

/**
 * Created by farhanahmad on 14/5/20.
 */
class AppRepositoryTest {

    lateinit var networkSource: INetworkSource
    lateinit var localSource: ILocalSource

    lateinit var appRepository: IAppRepository

    val tempList: List<LovooRoomDTO> = arrayListOf()

    @Before
    fun setUp() {
        networkSource = Mockito.mock(NetworkDataSourceImpl::class.java)
        localSource = Mockito.mock(LocalDataSource::class.java)

        appRepository = AppRepository(localSource, networkSource)

    }

    @After
    fun tearDown() {
    }

    @Test
    fun testGetRoomsMapping() = runBlockingTest {

        Mockito.`when`(networkSource.getRooms()).thenReturn(tempList)

        appRepository.getRooms()

        Mockito.verify(networkSource).getRooms()

    }

    @Test
    fun testGetRoomsNotNull() = runBlockingTest {

        val roomDTOList = arrayListOf<LovooRoomDTO>()
        roomDTOList.add(LovooRoomDTO("123", "R123", "R123"))

        Mockito.`when`(networkSource.getRooms()).thenReturn(roomDTOList)

        val list = appRepository.getRooms()

        assertNotNull(list)

    }

    @Test
    fun testGetRoomsNotEmpty() = runBlockingTest {

        val roomDTOList = arrayListOf<LovooRoomDTO>()
        roomDTOList.add(LovooRoomDTO("123", "R123", "R123"))

        Mockito.`when`(networkSource.getRooms()).thenReturn(roomDTOList)

        val list = appRepository.getRooms()

        assert(list.isNotEmpty())

    }

    @Test
    fun testGetRoomsCorrectMapping() = runBlockingTest {

        val roomDTOList = arrayListOf<LovooRoomDTO>()
        roomDTOList.add(LovooRoomDTO("123", "R123", "R123"))

        Mockito.`when`(networkSource.getRooms()).thenReturn(roomDTOList)

        val list = appRepository.getRooms()

        assertEquals("123", list[0].id)

    }

}