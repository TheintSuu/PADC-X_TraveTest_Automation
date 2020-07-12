package com.example.travelapp.activities.network.response

import com.example.travelapp.data.vos.PopularTourVO
import com.example.travelapp.utils.CODE_RESPONSE
import com.google.gson.annotations.SerializedName

data class GetAllPopularResponse(
    @SerializedName("code")val code: Int = 0,
    @SerializedName("message")val message: String = "",
    @SerializedName("data")val data: ArrayList<PopularTourVO> = arrayListOf()
    )
{
    fun isResponseOk(): Boolean {
        return data.isEmpty() && code == CODE_RESPONSE
    }


}