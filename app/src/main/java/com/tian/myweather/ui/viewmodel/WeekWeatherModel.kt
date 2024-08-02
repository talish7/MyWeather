package com.tian.myweather.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tian.myweather.config.Config.API_KEY
import com.tian.myweather.data.DataRepository
import com.tian.myweather.data.bean.AirBean
import com.tian.myweather.data.bean.DailyBean
import com.tian.myweather.data.bean.NowAirBean
import com.tian.myweather.data.bean.WeekWeatherBean
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * @Author: tian7
 * @Email: 253493510@qq.com
 * @Date: on 2024/7/13: 09: 17
 * @Description: 描述
 */
class WeekWeatherModel: ViewModel() {

    private val _weekWeather = MutableStateFlow<WeekWeatherBean?>(null)
    val weekWeather = _weekWeather.asStateFlow()

    private val _todayWeather = MutableStateFlow<DailyBean?>(null)
    val todayWeather = _todayWeather.asStateFlow()

    val cityId = mutableStateOf("101010100")
    val cityName = mutableStateOf("北京")

    private val _nowAir = MutableStateFlow<NowAirBean?>(null)
    val nowAir = _nowAir.asStateFlow()

    fun getWeekWeather(city: String){
        viewModelScope.launch {
            val response = DataRepository.getWeekWeather(city, API_KEY)
            if (response.code == "200") {
                response.daily?.get(0).let {
                    _todayWeather.value= response.daily?.get(0)
                }
                _weekWeather.value = response
            }else{
                dLog("${response.code}请求失败")
            }
        }
    }

    fun getAir(city: String){
        viewModelScope.launch {
            val response = DataRepository.getNowAir(city, API_KEY)
            if (response.code == "200") {
                _nowAir.value = response.nowAir
            }else{
                dLog("${response.code}请求失败")
            }
        }
    }

    fun dLog(msg: String) {
        Log.d("WeekWeatherModel", msg)
    }

}