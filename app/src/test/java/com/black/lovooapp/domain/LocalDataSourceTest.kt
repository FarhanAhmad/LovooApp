package com.black.lovooapp.domain

import com.black.lovooapp.domain.data.local.ILocalSource
import com.black.lovooapp.domain.data.local.LocalDataSource
import com.black.lovooapp.domain.db.AppDao
import com.black.lovooapp.domain.db.RoomBookingEntity
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

/**
 * Created by farhanahmad on 18/5/20.
 */
class LocalDataSourceTest {

    lateinit var appDao: AppDao
    lateinit var localDataSource: ILocalSource

    @Before
    fun setUp() {
        appDao = Mockito.mock(AppDao::class.java)
        localDataSource = LocalDataSource(appDao)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun testGetBookingsNotNull() = runBlockingTest {

        Mockito.`when`(appDao.getBookings("1")).thenReturn(emptyList())

        val list = localDataSource.getRoomBookings("1")

        assert(list != null)

    }

    @Test
    fun testGetBookingsEmpty() = runBlockingTest {

        Mockito.`when`(appDao.getBookings("1")).thenReturn(emptyList())

        val list = localDataSource.getRoomBookings("1")

        assert(list.isEmpty())
    }

    @Test
    fun testGetBookingsNotEmpty() = runBlockingTest {

        val tempList = arrayListOf<RoomBookingEntity>()
        tempList.add(RoomBookingEntity.createTempObj("1"))

        Mockito.`when`(appDao.getBookings("1")).thenReturn(tempList)

        val list = localDataSource.getRoomBookings("1")

        assert(list[0].roomNumber == "1")
    }

}