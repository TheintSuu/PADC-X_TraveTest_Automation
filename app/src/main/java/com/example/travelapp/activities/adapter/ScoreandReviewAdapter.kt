package com.example.travelapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.travelapp.R
import com.example.travelapp.data.vos.ScoreandReviewVO
import com.example.travelapp.view.viewholder.BaseViewHolder
import com.example.travelapp.view.viewholder.ScoreandReviewViewHolder


class ScoreandReviewAdapter: BaseAdapter<BaseViewHolder<ScoreandReviewVO>, ScoreandReviewVO>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<ScoreandReviewVO> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sorce_and_review_item_view,parent,false)
        return ScoreandReviewViewHolder(view)
    }
}