package com.tian.myweather.ui.viewmodel

import android.util.Log
import androidx.compose.material3.DatePicker
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.tian.myweather.config.Config.API_KEY
import com.tian.myweather.data.DataRepository
import com.tian.myweather.data.bean.NowWeatherBean
import com.tian.myweather.data.bean.HourWeatherBean
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import java.io.IOException

/**
 * @Author: tian7
 * @Email: 253493510@qq.com
 * @Date: on 2024/7/25: 23: 33
 * @Description: 描述
 */
class NowWeatherModel: ViewModel() {
    private val _nowWeather = MutableStateFlow<NowWeatherBean?>(null)
    val nowWeather = _nowWeather.asStateFlow()

    fun getNowWeather(city: String) {
         viewModelScope.launch {
            val nowWeatherBean =  DataRepository.getNowWeather(city,API_KEY)
             if (nowWeatherBean.code == "200") {
                 _nowWeather.value = nowWeatherBean
             }else{
                 dLog("请求失败")
             }
         }
    }
    fun dLog(msg: String) {
        Log.d("NowWeatherModel", msg)
    }
}