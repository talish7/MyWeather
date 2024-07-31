package com.tian.myweather.data.bean

import com.google.gson.annotations.SerializedName

/**
 * @Author: tian7
 * @Email: 253493510@qq.com
 * @Date: on 2024/7/13: 18: 54
 * @Description: 七天天气bean
 */

data class WeekWeatherBean (
    @SerializedName("code")
    val code: String? = null,

    @SerializedName("updateTime")
    val updateTime: String? = null,

    @SerializedName("daily")
    val daily: List<DailyBean>? = null,

)