package com.example.travelapp.data.vos

import androidx.room.Entity
import androidx.room.TypeConverters
import com.example.travelapp.activities.view.viewholder.PhotoTypeConventer
import com.example.travelapp.activities.view.viewholder.ScoreAndReviewTypeConverter
import com.google.gson.annotations.SerializedName

@Entity(tableName = "popular_tour")
@TypeConverters(ScoreAndReviewTypeConverter::class, PhotoTypeConventer::class)
data class PopularTourVO(
    @SerializedName("name")val name:String ="",
    @SerializedName("description") val description:String ="",
    @SerializedName("location")val location:String ="",
    @SerializedName("average_rating")val average_rating:Int = 0,
    @SerializedName("scores_and_reviews")val scores_and_reviews:ArrayList<ScoreandReviewVO> = arrayListOf(),
    @SerializedName("photos")val photos:ArrayList<String> = arrayListOf()
)