package com.example.travelapp.activities.data.models

import androidx.lifecycle.LiveData
import com.example.travelapp.data.vos.CountryVO
import com.example.travelapp.data.vos.DataVO
import com.example.travelapp.data.vos.PopularTourVO
import io.reactivex.Observable

interface CountryModel {

    fun getAllCountyFromDB(onError: (message: String) -> Unit):LiveData<List<CountryVO>>

    fun getAllPopularFromDB(onError: (message: String) -> Unit):LiveData<List<PopularTourVO>>

    fun getCommonApi(onError: (message: String) -> Unit) : Observable<DataVO>

    fun findTourById(name:String) : LiveData<CountryVO>

    fun findPopularTourById(name:String):LiveData<PopularTourVO>



}