package com.tian.myweather.data.bean

import com.google.gson.annotations.SerializedName

/**
 * @Author: tian7
 * @Email: 253493510@qq.com
 * @Date: on 2024/8/3: 11: 18
 * @Description: 描述
 */
data class NowAirBean(
    @SerializedName("aqi")
    val aqi: String? = null,
    @SerializedName("co")
    val co: String? = null,
    @SerializedName("no2")
    val no2: String? = null,
    @SerializedName("so2")
    val so2: String? = null,
    @SerializedName("o3")
    val o3: String? = null,
    @SerializedName("pm10")
    val pm10: String? = null,
    @SerializedName("pm2p5")
    val pm2p5: String?,
    @SerializedName("category")
    val quality: String? = null,


    )