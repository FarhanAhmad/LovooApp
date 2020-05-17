package com.black.lovooapp.domain.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.black.lovooapp.common.AppConstants

/**
 * Created by farhanahmad on 17/5/20.
 */
@Database(entities = [RoomBookingEntity::class], version = AppConstants.DB_VERSION)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getAppDao(): AppDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getDB(context: Context): AppDatabase {
            val tempInstance = instance
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        AppConstants.DB_NAME
                                                   ).build()
                instance = INSTANCE
                return INSTANCE
            }
        }
    }
}