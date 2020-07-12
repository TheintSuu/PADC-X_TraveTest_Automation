package com.example.travelapp.activities.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.travelapp.activities.data.models.CountryModel
import com.example.travelapp.activities.data.models.CountryModelImpl
import com.example.travelapp.activities.mvp.view.DetailsView
import com.example.travelapp.utils.VALUE_ONE
import com.example.travelapp.utils.VALUE_TWO

class DetailPresenterImpl : DetailPresenter, AbstractBasePresenter<DetailsView>() {

    private val mCountryModel: CountryModel = CountryModelImpl
    override fun onSwipeRefresh(lifecycleOwner: LifecycleOwner) {

    }

    override fun onDetailUiReadyState(name: String,value:Int, lifecycleOwner: LifecycleOwner) {
        when(value){
            VALUE_ONE ->{
                mCountryModel.findTourById(name).observe(lifecycleOwner, Observer {
                    mView?.displayCountryData(it)
                })
            }
            VALUE_TWO ->{
                mCountryModel.findPopularTourById(name).observe(lifecycleOwner, Observer {
                    mView?.displayTourData(it)
                })
            }
        }

    }
}