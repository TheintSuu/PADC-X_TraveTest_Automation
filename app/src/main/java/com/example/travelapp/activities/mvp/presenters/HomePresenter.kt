package com.example.travelapp.activities.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.example.travelapp.activities.mvp.view.BaseView
import com.example.travelapp.activities.mvp.view.HomeView
import com.example.travelapp.delegation.CountryItemDelegate

interface HomePresenter: BasePresenter<HomeView>, CountryItemDelegate {

    fun onSwipeRefresh(lifecycleOwner: LifecycleOwner)

    fun onUiReadyState(lifecycleOwner: LifecycleOwner)
}