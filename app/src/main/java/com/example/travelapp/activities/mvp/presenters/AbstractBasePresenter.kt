package com.example.travelapp.activities.mvp.presenters

import androidx.lifecycle.ViewModel
import com.example.travelapp.activities.mvp.view.BaseView

abstract class AbstractBasePresenter<T:BaseView> : BasePresenter<T>, ViewModel() {

    var mView: T? = null

    override fun initPresenter(view: T) {
        mView = view
    }

}