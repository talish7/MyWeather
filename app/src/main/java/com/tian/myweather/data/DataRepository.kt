package com.tian.myweather.data

import com.tian.myweather.config.Config.AIR_URL
import com.tian.myweather.config.Config.WEATHER_URL
import com.tian.myweather.data.bean.AirBean
import com.tian.myweather.data.bean.HourWeatherBean
import com.tian.myweather.data.bean.HourlyBean
import com.tian.myweather.data.bean.NowWeatherBean
import com.tian.myweather.data.bean.WeekWeatherBean
import com.tian.myweather.data.http.Api
import com.tian.myweather.ui.viewmodel.HourWeatherModel
import com.tian.myweather.ui.viewmodel.NowWeatherModel

/**
 * @Author: tian7
 * @Email: 253493510@qq.com
 * @Date: on 2024/7/30: 21: 19
 * @Description: 描述
 */
object DataRepository: Api {

    private val weatherService by lazy {
        RetrofitManager.getService(Api::class.java,WEATHER_URL)
    }
    private val airService by lazy {
        RetrofitManager.getService(Api::class.java,AIR_URL)
    }

    override suspend fun getWeekWeather(
        city: String,
        key: String
    ): WeekWeatherBean {
        return weatherService.getWeekWeather(city, key)
    }

    override suspend fun getHourWeather(
        city: String,
        key: String
    ): HourWeatherBean {
        return weatherService.getHourWeather(city, key)
    }

    override suspend fun getNowWeather(
        city: String,
        key: String
    ): NowWeatherBean {
        return weatherService.getNowWeather(city, key)
    }

    override suspend fun getNowAir(
        city: String,
        key: String
    ): AirBean {
        return airService.getNowAir(city, key)
    }


}