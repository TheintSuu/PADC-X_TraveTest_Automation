package com.example.travelapp.activities.data.models

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import com.aungpyaesone.padc_x_travel_app_aps.data.models.BaseModel
import com.example.travelapp.data.vos.CountryVO
import com.example.travelapp.data.vos.DataVO
import com.example.travelapp.data.vos.PopularTourVO
import com.example.travelapp.utils.EN_CONNECTION_ERROR
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers

object CountryModelImpl: BaseModel(), CountryModel {


    override fun findPopularTourById(name: String): LiveData<PopularTourVO> {
        return mTheDB.PopularTravelDao().getTourById(name)
    }

    override fun getAllPopularFromDB(onError: (message: String) -> Unit): LiveData<List<PopularTourVO>> {
        return mTheDB.PopularTravelDao().getAllCountryList()
    }

    override fun getAllCountyFromDB(onError: (message: String) -> Unit): LiveData<List<CountryVO>> {
        return mTheDB.TravelDao().getAllCountryList()
    }

/*
    override fun getTwoApi(onError:(message:String)->Unit): Observable<List<CountryVO>>{
        return Observable.zip(
            mNetworkApi.getAllCourntries().map { it.data.toList() }.subscribeOn(Schedulers.io()),
            mNetworkApi.getAllTours()
                .map { it.data.toList() }
                .subscribeOn(Schedulers.io()),
            mergeList()
        ).subscribeOn(Schedulers.io())
    }
    private fun mergeList():BiFunction<List<CountryVO>,List<CountryVO>,List<CountryVO>>{
        val dataList = ArrayList<CountryVO>()
        return BiFunction { one, two->
            one.forEach {
                dataList.add(it)
            }
            two.forEach {
                dataList.add(it)
            }
            dataList
        }
    }*/

    @SuppressLint("CheckResult")
    override fun getCommonApi(onError: (message: String) -> Unit): Observable<DataVO> {
        val observableOne = mNetworkApi.getAllCourntries()
            .filter { it.isResponseOk() }
            .map { it.data.toList() }.subscribeOn(Schedulers.io())

        val observableTwo = mNetworkApi.getAllTours()
            .filter { it.isResponseOk() }
            .map {
                it.data.toList()}
            .subscribeOn(Schedulers.io())


        val zipData = Observable.zip(
            observableOne,
            observableTwo,
            createDataVOModel())

        observableOne.subscribeOn(AndroidSchedulers.mainThread())
            .subscribe ({

                mTheDB.TravelDao().insertAllData(it) },{
                Log.e("error",it?.localizedMessage.toString())
                onError(it.localizedMessage ?: EN_CONNECTION_ERROR)
            })
        observableTwo.subscribeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                mTheDB.PopularTravelDao().insertAllData(it)
            },{
                Log.e("error",it?.localizedMessage.toString())
            })

        return zipData.subscribeOn(Schedulers.io())
    }

    private fun createDataVOModel(): BiFunction<List<CountryVO>, List<PopularTourVO>, DataVO> {
        val dataList = ArrayList<CountryVO>()
        val popularList = ArrayList<PopularTourVO>()
        return BiFunction { one, two->
            one.forEach {
                dataList.add(it)
            }
            two.forEach {
                popularList.add(it)
            }
            DataVO(dataList,popularList)
        }
    }


    override fun findTourById(name: String): LiveData<CountryVO> {
        return mTheDB.TravelDao().getTourById(name)
    }
}