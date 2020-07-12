package com.example.travelapp.activities.mvp.presenters

import com.example.travelapp.activities.mvp.view.BaseView

interface BasePresenter<T: BaseView> {

    fun initPresenter(view: T)
}