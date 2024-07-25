package com.tian.myweather.data.bean

import com.google.gson.annotations.SerializedName

/**
 * @Author: tian7
 * @Email: 253493510@qq.com
 * @Date: on 2024/7/25: 23: 35
 * @Description: 描述
 */
class NowWeatherBean {

    @SerializedName("code")
    var code: String? = null

    @SerializedName("now")
    var now: NowBean? = null

    override fun toString(): String {
        return "NowWeatherBean(code=$code, now=$now)"
    }

}