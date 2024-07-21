package com.tian.myweather.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.tian.myweather.data.bean.WeekWeatherBean
import okhttp3.OkHttpClient
import java.io.IOException

/**
 * @Author: tian7
 * @Email: 253493510@qq.com
 * @Date: on 2024/7/13: 09: 17
 * @Description: 描述
 */
class DayWeatherModel: ViewModel() {

    val cityId = mutableStateOf("101010100")
    val cityName = mutableStateOf("北京")
    val tempMin = mutableStateOf("")
    val tempMax = mutableStateOf("")
    val todayWeather = mutableStateOf("暂无")
    val result = mutableStateOf<WeekWeatherBean?>(null)

    fun getDayWeather(city: String) {
        val client = OkHttpClient()
        val url = "$BASE_URL&location=$city&key=${API_KEY}"
        val request = okhttp3.Request.Builder().get().url(url).build()
        client.newCall(request).enqueue(object : okhttp3.Callback {
            override fun onFailure(call: okhttp3.Call, e: IOException) {
                dLog("请求失败")
            }
            override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                val json = response.body?.string()
                val weatherBean = Gson().fromJson(json!!, WeekWeatherBean::class.java)
                if (weatherBean.daily?.get(0) != null){
                    tempMax.value = weatherBean.daily?.get(0)?.tempMax.toString()
                    tempMin.value = weatherBean.daily?.get(0)?.tempMin.toString()
                    todayWeather.value = weatherBean.daily?.get(0)?.textDay.toString()
                }
                result.value = weatherBean
                dLog("result: $result")
            }
        })
    }

    fun dLog(msg: String) {
        Log.d("DayWeatherModel", msg)
    }

}