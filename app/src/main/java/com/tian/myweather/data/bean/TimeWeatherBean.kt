package com.tian.myweather.data.bean

import com.google.gson.annotations.SerializedName

/**
 * @Author: tian7
 * @Email: 253493510@qq.com
 * @Date: on 2024/7/20: 22: 46
 * @Description: 描述
 */

class TimeWeatherBean{
    @SerializedName("code")
    var code: String? = null

    @SerializedName("hourly")
    var hourly: List<HourlyBean>? = null

    override fun toString(): String {
        return "TimeWeatherBean(code=$code, hourly=$hourly)"
    }

}