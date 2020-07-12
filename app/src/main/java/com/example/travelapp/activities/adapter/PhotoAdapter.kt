package com.example.travelapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.travelapp.R
import com.example.travelapp.view.viewholder.BaseViewHolder
import com.example.travelapp.view.viewholder.PhotoViewHolder


class PhotoAdapter: BaseAdapter<BaseViewHolder<String>, String>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<String> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.photo_item_view,parent,false)
        return PhotoViewHolder(view)
    }
}