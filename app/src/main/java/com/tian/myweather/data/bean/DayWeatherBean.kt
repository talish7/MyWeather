package com.tian.myweather.data.bean

import com.google.gson.annotations.SerializedName

/**
 * @Author: tian7
 * @Email: 253493510@qq.com
 * @Date: on 2024/7/13: 19: 04
 * @Description: 每日天气bean
 */

class DayWeatherBean {

    @SerializedName("fxDate")
    var date: String? = null

    //日出时间
    @SerializedName("sunrise")
    var sunrise: String? = null

    //日落时间
    @SerializedName("sunset")
    var sunset: String? = null

    //月升时间
    @SerializedName("moonrise")
    var moonrise: String? = null
    //月落时间
    @SerializedName("moonset")
    var moonset: String? = null

    //最高温度
    @SerializedName("tempMax")
    var tempMax: String? = null

    //最低温度
    @SerializedName("tempMin")
    var tempMin: String? = null

    //白天天气图标
    @SerializedName("iconDay")
    var iconDay: String? = null

    //白天天气描述
    @SerializedName("textDay")
    var textDay: String? = null

    //夜间天气图标
    @SerializedName("iconNight")
    var iconNight: String? = null

    //夜间天气文字描述
    @SerializedName("textNight")
    var textNight: String? = null

    //白天风向360角度
    @SerializedName("wind360Day")
    var wind360: String? = null

    //白天风向
    @SerializedName("windDirDay")
    var windDir: String? = null

    override fun toString(): String {
        return "DayWeatherBean(date=$date, sunrise=$sunrise, sunset=$sunset, moonrise=$moonrise, moonset=$moonset, tempMax=$tempMax, tempMin=$tempMin, iconDay=$iconDay, textDay=$textDay, iconNight=$iconNight, textNight=$textNight, wind360=$wind360, windDir=$windDir)"
    }


}