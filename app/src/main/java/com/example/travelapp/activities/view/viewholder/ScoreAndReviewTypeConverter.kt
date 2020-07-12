package com.example.travelapp.activities.view.viewholder

import androidx.room.TypeConverter
import com.example.travelapp.data.vos.ScoreandReviewVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ScoreAndReviewTypeConverter {
    @TypeConverter
    fun toString(dataList:ArrayList<ScoreandReviewVO>):String{
        return Gson().toJson(dataList)
    }

    @TypeConverter
    fun toCountryList(countryListJsonStr:String):ArrayList<ScoreandReviewVO>{
        val countryListType = object : TypeToken<ArrayList<ScoreandReviewVO>>(){}.type
        return Gson().fromJson(countryListJsonStr,countryListType)
    }
}