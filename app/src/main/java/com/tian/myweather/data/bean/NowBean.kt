package com.tian.myweather.data.bean

import com.google.gson.annotations.SerializedName

class NowBean {

    @SerializedName("temp")
    var temp: String? = null

    @SerializedName("text")
    var weather: String? = null

    @SerializedName("obsTime")
    var obsTime: String? = null

    override fun toString(): String {
        return "NowBean(temp=$temp, weather=$weather, obsTime=$obsTime)"
    }


}
