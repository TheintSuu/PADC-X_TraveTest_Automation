package com.example.travelapp.activities.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.travelapp.data.vos.CountryVO


@Dao
interface TravelDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllData(infos: List<CountryVO>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCountry(country: CountryVO)

    @Query("select * from country where name= :name")
    fun getTourById(name: String): LiveData<CountryVO>

    @Query("select * from country")

    fun getAllCountryList(): LiveData<List<CountryVO>>


}