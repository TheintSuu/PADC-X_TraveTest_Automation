package com.example.travelapp.activities.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.travelapp.data.vos.PopularTourVO

@Dao
interface PopularTravelDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllData(infos: List<PopularTourVO>)

    @Query("select * from popular_tour where name= :name")
    fun getTourById(name: String): LiveData<PopularTourVO>

    @Query("select * from popular_tour")

    fun getAllCountryList(): LiveData<List<PopularTourVO>>
}
