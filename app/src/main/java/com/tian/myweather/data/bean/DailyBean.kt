package com.tian.myweather.data.bean

import com.google.gson.annotations.SerializedName

/**
 * @Author: tian7
 * @Email: 253493510@qq.com
 * @Date: on 2024/7/13: 19: 04
 * @Description: 每日天气bean
 */

data class DailyBean(

    @SerializedName("fxDate")
    val date: String? = null,

    //日出时间
    @SerializedName("sunrise")
    val sunrise: String? = null,

    //日落时间
    @SerializedName("sunset")
    val sunset: String? = null,

    //月升时间
    @SerializedName("moonrise")
    val moonrise: String? = null,
    //月落时间
    @SerializedName("moonset")
    val moonset: String? = null,

    //最高温度
    @SerializedName("tempMax")
    val tempMax: String? = null,

    //最低温度
    @SerializedName("tempMin")
    val tempMin: String? = null,

    //白天天气图标
    @SerializedName("iconDay")
    val iconDay: String? = null,

    //白天天气描述
    @SerializedName("textDay")
    val textDay: String? = null,

    //夜间天气图标
    @SerializedName("iconNight")
    val iconNight: String? = null,

    //夜间天气文字描述
    @SerializedName("textNight")
    val textNight: String? = null,

    //白天风向360角度
    @SerializedName("wind360Day")
    val wind360: String? = null,

    //白天风向
    @SerializedName("windDirDay")
    val windDir: String? = null
)