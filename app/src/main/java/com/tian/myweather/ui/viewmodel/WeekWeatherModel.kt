package com.tian.myweather.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tian.myweather.config.Config.API_KEY
import com.tian.myweather.data.DataRepository
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
    private val _weekWeathers = MutableStateFlow<WeekWeatherBean?>(null)
    val weekWeathers = _weekWeathers.asStateFlow()

    val cityId = mutableStateOf("101010100")
    val cityName = mutableStateOf("北京")
    val tempMin = mutableStateOf("")
    val tempMax = mutableStateOf("")
    val todayWeather = mutableStateOf("暂无")
    val result = mutableStateOf<WeekWeatherBean?>(null)
    val icon = mutableStateOf("")
    
    fun getWeekWeather(city: String){
        viewModelScope.launch {
            val response = DataRepository.getWeekWeather(city, API_KEY)
            if (response.code == "200") {
                response.daily?.get(0).let {
                    tempMax.value = response.daily?.get(0)?.tempMax.toString()
                    tempMin.value = response.daily?.get(0)?.tempMin.toString()
                    todayWeather.value = response.daily?.get(0)?.textDay.toString()
                    icon.value = response.daily?.get(0)?.iconDay.toString()
                    result.value = response
                    _weekWeathers.value = response
                    dLog("result: $result")
                }
            }else{
                dLog("${response.code}请求失败")
            }

        }
    }

    fun dLog(msg: String) {
        Log.d("WeekWeatherModel", msg)
    }

}