package com.tian.myweather.data.bean

import com.google.gson.annotations.SerializedName

/**
 * @Author: tian7
 * @Email: 253493510@qq.com
 * @Date: on 2024/7/20: 22: 46
 * @Description: 描述
 */

data class HourWeatherBean(

    @SerializedName("code")
    val code: String? = null,

    @SerializedName("hourly")
    val hourly: List<HourlyBean>? = null
)



