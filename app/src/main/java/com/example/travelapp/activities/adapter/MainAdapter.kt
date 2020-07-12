package com.example.travelapp.activities.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.travelapp.R
import com.example.travelapp.activities.view.viewholder.MainViewHolder
import com.example.travelapp.adapter.BaseAdapter
import com.example.travelapp.data.vos.DataVO
import com.example.travelapp.delegation.CountryItemDelegate
import com.example.travelapp.view.viewholder.BaseViewHolder

class MainAdapter(delegate: CountryItemDelegate): BaseAdapter<BaseViewHolder<DataVO>, DataVO>() {

    val mDelegate = delegate

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<DataVO> {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.main_item_view, parent, false)
        return MainViewHolder(view, mDelegate)
    }
}
