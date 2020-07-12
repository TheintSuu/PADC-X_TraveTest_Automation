package com.example.travelapp.network.respinse

import com.example.travelapp.activities.network.response.GetAllPopularResponse
import com.example.travelapp.network.response.GetAllCountryResponse
import com.example.travelapp.utils.GET_ALL_COUNTRY
import com.example.travelapp.utils.GET_ALL_TOUR
import io.reactivex.Observable


import retrofit2.http.GET

interface TourApi {
    @GET(GET_ALL_COUNTRY)
    fun getAllCourntries(): Observable<GetAllCountryResponse>

    @GET(GET_ALL_TOUR)
    fun getAllTours(): Observable<GetAllPopularResponse>

}