package com.tian.myweather.data.bean

import com.google.gson.annotations.SerializedName

/**
 * @Author: tian7
 * @Email: 253493510@qq.com
 * @Date: on 2024/7/20: 22: 50
 * @Description: 描述
 */
//{
//    "fxTime": "2021-02-16T15:00+08:00",
//    "temp": "2",
//    "icon": "100",
//    "text": "晴",
//    "wind360": "335",
//    "windDir": "西北风",
//    "windScale": "3-4",
//    "windSpeed": "20",
//    "humidity": "11",
//    "pop": "0",
//    "precip": "0.0",
//    "pressure": "1025",
//    "cloud": "0",
//    "dew": "-25"
//},
data class HourlyBean (

    @SerializedName("fxTime")
    var time: String? = null,

    @SerializedName("temp")
    var temp: String? = null,

    @SerializedName("icon")
    var icon: String? = null,

    @SerializedName("text")
    var weather: String? = null
)
