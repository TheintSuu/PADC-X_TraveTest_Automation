package com.example.travelapp.activities.mvp.view

import com.example.travelapp.data.vos.CountryVO
import com.example.travelapp.data.vos.DataVO

interface HomeView: BaseView {

    fun displayTourList(tourList: DataVO)
    fun enableSwipeRefresh()
    fun disableSwipeRefresh()

    fun showEmptyView()
    fun hideEmptyView()

    fun navigateToTourDetail(name:String,value:Int)
}