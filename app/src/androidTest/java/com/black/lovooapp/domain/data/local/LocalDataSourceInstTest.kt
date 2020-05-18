package com.black.lovooapp.domain.data.local

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.black.lovooapp.domain.db.AppDao
import com.black.lovooapp.domain.db.AppDatabase
import com.black.lovooapp.domain.db.RoomBookingEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

/**
 * Created by farhanahmad on 18/5/20.
 */
class LocalDataSourceInstTest {

    lateinit var appDao: AppDao
    lateinit var appDb: AppDatabase

    @Before
    fun setUp() {

        val context = ApplicationProvider.getApplicationContext<Context>()

        appDb = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()

        appDao = appDb.getAppDao()

    }

    @After
    fun tearDown() {

        appDb.clearAllTables()
        appDb.close()
    }

    @Test
    fun testBookingInsertion() = runBlocking(Dispatchers.IO) {

        val tempEntity = RoomBookingEntity.createTempObj("1")
        appDao.insertBooking(tempEntity)

        val list = appDao.getBookings("1")

        assert(list[0].roomNumber == "1")
    }

    @Test
    fun testBookingTableEmpty() = runBlocking(Dispatchers.IO) {

        val list = appDao.getBookings("1")

        assert(list.isEmpty())
    }
}