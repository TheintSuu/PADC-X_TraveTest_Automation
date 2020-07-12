package com.example.travelapp.activities.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.travelapp.activities.data.models.CountryModel
import com.example.travelapp.activities.data.models.CountryModelImpl
import com.example.travelapp.activities.mvp.view.HomeView
import com.example.travelapp.data.vos.DataVO
import io.reactivex.disposables.CompositeDisposable

class HomePresenterImpl: HomePresenter, AbstractBasePresenter<HomeView>() {

    var mCountryModel:CountryModel = CountryModelImpl
    private lateinit var dataVO: DataVO

    //  var mCountryModel : CountryModel = CountryModelImpl
    private val compositeDisposable = CompositeDisposable()

    override fun onSwipeRefresh(lifecycleOwner: LifecycleOwner) {
        getCountryData(lifecycleOwner)
    }

    override fun onUiReadyState(lifecycleOwner: LifecycleOwner) {
        getCountryData(lifecycleOwner)
    }

    override fun onTapCountryItem(name: String,value: Int) {
        mView?.navigateToTourDetail(name,value)
    }

    private fun getCountryData(lifecycleOwner: LifecycleOwner){
        dataVO = DataVO(arrayListOf(), arrayListOf())
        /*mCountryModel.getCommonApi(onError = {
            mView?.disableSwipeRefresh()
            mView?.showEmptyView()
            mView?.showErrorMessage(it)
        }).observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mView?.disableSwipeRefresh()
                if (it.countryList.isNotEmpty() && it.popourTourList.isNotEmpty()) {
                    mView?.showEmptyView()
                  //  dataVO.countryList = it.countryList
                  //  dataVO.popourTourList = it.popourTourList
                    mView?.displayTourList(it)
                }
                else {
                mView?.showErrorMessage(EN_CONNECTION_ERROR)
                }
            },
                {
                mView?.showErrorMessage(it.localizedMessage)
                })
            .addTo(compositeDisposable)*/

        mCountryModel.getAllCountyFromDB(onError = {
            mView?.disableSwipeRefresh()
            mView?.showEmptyView()
            mView?.showErrorMessage(it)
        })
            .observe(lifecycleOwner, Observer {
                mView?.disableSwipeRefresh()
                if(it.isEmpty())
                {
                    mView?.showEmptyView()
                }else{
                    mView?.hideEmptyView()
                    dataVO.countryList = it
                    mView?.displayTourList(dataVO)
                }
            })

        mCountryModel.getAllPopularFromDB(onError = {
            mView?.disableSwipeRefresh()
            mView?.showEmptyView()
            mView?.showErrorMessage(it)
        })
            .observe(lifecycleOwner, Observer {
                mView?.disableSwipeRefresh()
                if(it.isEmpty())
                {
                    mView?.showEmptyView()
                }else
                {
                    mView?.hideEmptyView()
                    dataVO.popourTourList = it
                    mView?.displayTourList(dataVO)
                }
            }
            )

    }
}