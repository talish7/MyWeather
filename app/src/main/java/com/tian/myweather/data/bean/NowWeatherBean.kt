package com.tian.myweather.data.bean

import com.google.gson.annotations.SerializedName

/**
 * @Author: tian7
 * @Email: 253493510@qq.com
 * @Date: on 2024/7/25: 23: 35
 * @Description: 描述
 */
data class NowWeatherBean (

    @SerializedName("code")
    val code: String? = null,

    @SerializedName("now")
    val now: NowBean? = null
)



