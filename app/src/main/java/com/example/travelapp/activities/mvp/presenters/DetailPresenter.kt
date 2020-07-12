package com.example.travelapp.activities.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.example.travelapp.activities.mvp.view.DetailsView

interface DetailPresenter : BasePresenter<DetailsView> {

    fun onSwipeRefresh(lifecycleOwner: LifecycleOwner)

    fun onDetailUiReadyState(name:String,value:Int,lifecycleOwner: LifecycleOwner)
}