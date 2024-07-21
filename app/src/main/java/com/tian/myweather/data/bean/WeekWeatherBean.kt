package com.tian.myweather.data.bean

import com.google.gson.annotations.SerializedName

/**
 * @Author: tian7
 * @Email: 253493510@qq.com
 * @Date: on 2024/7/13: 18: 54
 * @Description: 七天天气bean
 */

class WeekWeatherBean {
    @SerializedName("code")
    var code: String? = null

    @SerializedName("updateTime")
    var updateTime: String? = null

    @SerializedName("daily")
    var daily: List<DayWeatherBean>? = null

    override fun toString(): String {
        return "WeekWeatherBean(code=$code, updateTime=$updateTime, daily=$daily)"
    }


}