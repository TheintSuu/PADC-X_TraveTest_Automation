package com.example.travelapp.adapter

import com.example.travelapp.R
import com.example.travelapp.delegation.CountryItemDelegate
import com.example.travelapp.view.viewholder.BaseViewHolder
import com.example.travelapp.view.viewholder.PopularTourViewHolder
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.travelapp.data.vos.PopularTourVO


class PopularTourListAdapter(delegate: CountryItemDelegate) : BaseAdapter<BaseViewHolder<PopularTourVO>, PopularTourVO>() {
    val mDelegate = delegate
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<PopularTourVO> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.vertical_item_view, parent,false)
        return PopularTourViewHolder(view,mDelegate)
    }
}
