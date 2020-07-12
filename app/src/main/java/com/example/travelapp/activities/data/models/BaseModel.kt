package com.aungpyaesone.padc_x_travel_app_aps.data.models

import android.content.Context
import android.icu.util.TimeUnit
import com.example.travelapp.activities.persistence.daos.TravelDao
import com.example.travelapp.network.respinse.TourApi
import com.example.travelapp.utils.BASE_URL
import com.zg.burgerjoint.persistence.TravelJointDatabase
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


abstract class BaseModel  {

    protected var mNetworkApi: TourApi
    protected lateinit var mTheDB: TravelJointDatabase

    init {
        val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, java.util.concurrent.TimeUnit.SECONDS)
            .readTimeout(15, java.util.concurrent.TimeUnit.SECONDS)
            .writeTimeout(15, java.util.concurrent.TimeUnit.SECONDS)
            .build()

        // val headerInterceptor =

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(mOkHttpClient)
            .build()

        mNetworkApi = retrofit.create(TourApi::class.java)
    }

    fun initDatabase(context: Context){
        mTheDB = TravelJointDatabase.getInstance(context)
    }

}