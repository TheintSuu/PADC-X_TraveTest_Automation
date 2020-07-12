package com.example.travelapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup


import com.example.travelapp.R

import com.example.travelapp.data.vos.CountryVO
import com.example.travelapp.delegation.CountryItemDelegate
import com.example.travelapp.view.viewholder.BaseViewHolder
import com.example.travelapp.view.viewholder.CountryViewHolder

class CountryListAdapter(delegate: CountryItemDelegate) : BaseAdapter<BaseViewHolder<CountryVO>, CountryVO>() {

    val mDelegate = delegate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<CountryVO> {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.horizontal_item_view, parent, false)
        return CountryViewHolder(view, mDelegate)
    }
}