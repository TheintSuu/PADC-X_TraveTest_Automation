package com.example.travelapp.activities.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.travelapp.activities.persistence.daos.PopularTravelDao
import com.example.travelapp.data.vos.PopularTourVO

@Database(
    entities = [
        PopularTourVO::class
    ],
    version = 1,
    exportSchema = false
)
abstract class PopularTravelJointDatabase : RoomDatabase() {
    abstract fun getBurgerDao() : PopularTravelDao

    companion object {

        private const val DB_NAME = "BurgerJoint.db"

        @Volatile
        private var INSTANCE: PopularTravelJointDatabase? = null

        fun getInstance(context: Context):PopularTravelJointDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                PopularTravelJointDatabase::class.java, DB_NAME
            )
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()

    }
}

