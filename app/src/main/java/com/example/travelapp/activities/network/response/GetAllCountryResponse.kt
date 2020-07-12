package com.example.travelapp.network.response


import com.example.travelapp.data.vos.CountryVO
import com.example.travelapp.data.vos.DataVO
import com.example.travelapp.utils.CODE_RESPONSE
import com.google.gson.annotations.SerializedName

data class GetAllCountryResponse (
    @SerializedName("code")val code: Int = 0,
    @SerializedName("message")val message: String = "",
    @SerializedName("data")val data: ArrayList<CountryVO> = arrayListOf()) {

    fun isResponseOk(): Boolean {
        return data.isEmpty() && code == CODE_RESPONSE
    }
}