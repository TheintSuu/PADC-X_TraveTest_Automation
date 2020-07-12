package com.zg.burgerjoint.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.travelapp.activities.persistence.daos.PopularTravelDao
import com.example.travelapp.activities.persistence.daos.TravelDao
import com.example.travelapp.activities.view.viewholder.PhotoTypeConventer
import com.example.travelapp.activities.view.viewholder.ScoreAndReviewTypeConverter
import com.example.travelapp.data.vos.CountryVO
import com.example.travelapp.data.vos.PopularTourVO

@Database(entities = [CountryVO::class, PopularTourVO::class],version = 2,exportSchema = false)
@TypeConverters(ScoreAndReviewTypeConverter::class, PhotoTypeConventer::class)
abstract class TravelJointDatabase : RoomDatabase() {
    companion object{
        val DB_NAME ="PADC_X_Travel_DB"
        var dbInstance: TravelJointDatabase? = null

        fun getInstance(context: Context): TravelJointDatabase{
            when(dbInstance){
                null ->{
                    dbInstance = Room.databaseBuilder(context,TravelJointDatabase::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            val i = dbInstance
            return i!!
        }
    }
    abstract fun TravelDao(): TravelDao
    abstract fun PopularTravelDao(): PopularTravelDao
}