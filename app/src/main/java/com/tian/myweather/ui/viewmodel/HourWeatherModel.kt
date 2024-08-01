package com.tian.myweather.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.tian.myweather.config.Config.API_KEY
import com.tian.myweather.data.DataRepository
import com.tian.myweather.data.bean.HourWeatherBean
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import java.io.IOException

/**
 * @Author: tian7
 * @Email: 253493510@qq.com
 * @Date: on 2024/7/20: 22: 42
 * @Description: 描述
 */
class HourWeatherModel: ViewModel() {
    val cityId = mutableStateOf("101010100")
    private val _hourWeather = MutableStateFlow<HourWeatherBean?>(null)
    val hourWeather = _hourWeather.asStateFlow()
    fun getHourWeather(city: String) {
        viewModelScope.launch {
            val hourWeatherBean = DataRepository.getHourWeather(city, API_KEY)
            if(hourWeatherBean.code == "200" ) {
                hourWeatherBean?.let {
                    _hourWeather.value = it
                }
                dLog("请求成功+${hourWeatherBean?.toString()}")
            }else{
                dLog("请求失败")
            }
        }
    }
    fun dLog(msg: String) {
        Log.d("HourWeatherModel", msg)
    }
}