package com.tian.myweather.utils

import com.tian.myweather.R

/**
 * @Author: tian7
 * @Email: 253493510@qq.com
 * @Date: on 2024/7/27: 04: 23
 * @Description: 描述
 */

fun getIconOfWeather(id: String): Int {
    return when (id) {
        "100", "150" -> R.drawable.ic_sunny
        "101", "102", "151", "152", "153" -> R.drawable.ic_cloudy
        "104" -> R.drawable.ic_yin
        "300", "301", "305", "306", "307", "308", "309", "310", "311", "312", "313", "314", "315", "316", "317", "318" -> R.drawable.ic_rain
        "302", "303", "304" -> R.drawable.ic_thunderstorm // 雷雨（注意这里可能有重复，根据实际情况调整）
        "400", "401", "402", "403", "404", "405", "406", "407", "409", "410", "457", "499" -> R.drawable.ic_snow
        "500", "501", "509", "510", "514", "515" -> R.drawable.ic_foggy // 雾
        "502", "511", "512", "513" -> R.drawable.ic_haze // 霾
        "507", "508" -> R.drawable.ic_duststorm // 沙尘暴
        else -> R.drawable.ic_unknown
    }
}