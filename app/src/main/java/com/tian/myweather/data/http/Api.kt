package com.tian.myweather.data.http

import com.tian.myweather.data.bean.AirBean
import com.tian.myweather.data.bean.HourWeatherBean
import com.tian.myweather.data.bean.HourlyBean
import com.tian.myweather.data.bean.NowWeatherBean
import com.tian.myweather.data.bean.WeekWeatherBean
import com.tian.myweather.ui.viewmodel.NowWeatherModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @Author: tian7
 * @Email: 253493510@qq.com
 * @Date: on 2024/7/30: 21: 25
 * @Description: 描述
 */
interface Api {
    /**
     * 获取未来7天天气信息
     */
    @GET("7d")
    suspend fun getWeekWeather(
        @Query("location") city: String,
        @Query("key") key: String,
    ): WeekWeatherBean

    /**
     * 获取未来24小时天气信息
     */
    @GET("24h")
    suspend fun getHourWeather(
        @Query("location") city: String,
        @Query("key") key: String,
    ): HourWeatherBean

    /**
     * 获取实时天气信息
     */
    @GET("now")
    suspend fun getNowWeather(
        @Query("location") city: String,
        @Query("key") key: String,
    ): NowWeatherBean

    /**
     * 获取实时空气质量信息
     */
    @GET("now")
    suspend fun getNowAir(
        @Query("location") city: String,
        @Query("key") key: String,
    ): AirBean
}