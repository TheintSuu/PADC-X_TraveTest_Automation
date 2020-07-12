package com.example.travelapp.activities.mvp.view

import com.example.travelapp.data.vos.CountryVO
import com.example.travelapp.data.vos.PopularTourVO

interface DetailsView : BaseView {

    fun displayTourData(tourdata: PopularTourVO)

    fun displayCountryData(countrydata: CountryVO)
}