package com.example.travelapp.view.viewholder

import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.example.travelapp.data.vos.CountryVO
import com.example.travelapp.delegation.CountryItemDelegate
import com.example.travelapp.utils.VALUE_ONE
import kotlinx.android.synthetic.main.horizontal_item_view.view.*

class CountryViewHolder(itemView: View,delegate: CountryItemDelegate) : BaseViewHolder<CountryVO>(itemView) {

    init {
        itemView.setOnClickListener {
            mData?.let {
                delegate.onTapCountryItem(it.name, VALUE_ONE)
            }

        }
    }

    override fun bindData(data: CountryVO) {
        mData = data

        Glide.with(itemView.context)
            .load(data.photos[1])
            .centerCrop()
            .into(itemView.imgTravel)

        val str:String = getCountryName(data.location)
        itemView.tvLocation.text = str
        itemView.tvRating.text = data.average_rating.toString()
        Log.d("location",data.location)


    }

}