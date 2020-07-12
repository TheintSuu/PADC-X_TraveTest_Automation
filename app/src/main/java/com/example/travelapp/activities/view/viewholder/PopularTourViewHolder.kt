package com.example.travelapp.view.viewholder

import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.example.travelapp.data.vos.CountryVO
import com.example.travelapp.data.vos.PopularTourVO
import com.example.travelapp.delegation.CountryItemDelegate
import com.example.travelapp.utils.VALUE_TWO
import kotlinx.android.synthetic.main.vertical_item_view.view.*

class PopularTourViewHolder(itemView: View,delegate: CountryItemDelegate) : BaseViewHolder<PopularTourVO>(itemView) {

    init {
        itemView.setOnClickListener {
            mData?.let {
                delegate.onTapCountryItem(it.name, VALUE_TWO)
            }

        }
    }

    override fun bindData(data: PopularTourVO) {
        mData = data
        Glide.with(itemView.context)
            .load(data.photos[1])
            .centerCrop()
            .into(itemView.ImgOne)

        val title:String = getCountryName(data.location)
        itemView.title.text = title
        itemView.tvRate.text = data.average_rating.toString()
        Log.d("title",title)

    }
}