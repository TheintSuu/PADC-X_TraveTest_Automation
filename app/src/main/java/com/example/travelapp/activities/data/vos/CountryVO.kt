package com.example.travelapp.data.vos

import androidx.room.Entity
import androidx.room.TypeConverters
import com.example.travelapp.activities.view.viewholder.PhotoTypeConventer
import com.example.travelapp.activities.view.viewholder.ScoreAndReviewTypeConverter
import com.google.gson.annotations.SerializedName

@Entity(tableName = "country")
@TypeConverters(ScoreAndReviewTypeConverter::class, PhotoTypeConventer::class)
data class CountryVO(
    @SerializedName("name")var name:String ="",
    @SerializedName("description")var description:String ="",
    @SerializedName("location")var location:String ="",
    @SerializedName("average_rating")var average_rating:Double =0.0,
    @SerializedName("scores_and_reviews")var scores_and_reviews:ArrayList<ScoreandReviewVO> = arrayListOf(),
    @SerializedName("photos")var photos:ArrayList<String> = arrayListOf()
)
