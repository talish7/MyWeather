package com.tian.myweather.data.bean

import com.google.gson.annotations.SerializedName

data class NowBean (

    @SerializedName("temp")
    val temp: String? = null,

    @SerializedName("text")
    val weather: String? = null,

    @SerializedName("obsTime")
    val obsTime: String? = null,

    @SerializedName("icon")
    val icon: String? = null

)


