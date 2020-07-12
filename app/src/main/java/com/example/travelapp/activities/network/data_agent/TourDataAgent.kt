package com.example.travelapp.network.data_agent


import com.example.travelapp.data.vos.CountryVO

interface TourDataAgent {

    fun getAllTours(accessToken:String, onSuccess: (List<CountryVO>, List<CountryVO>)->Unit,
                    onFailure: (String)->Unit)

}