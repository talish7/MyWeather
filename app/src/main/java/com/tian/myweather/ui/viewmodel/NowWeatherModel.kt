package com.tian.myweather.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.tian.myweather.data.bean.NowWeatherBean
import com.tian.myweather.data.bean.TimeWeatherBean
import okhttp3.OkHttpClient
import java.io.IOException

/**
 * @Author: tian7
 * @Email: 253493510@qq.com
 * @Date: on 2024/7/25: 23: 33
 * @Description: 描述
 */
class NowWeatherModel: ViewModel() {

    val result = mutableStateOf<NowWeatherBean?>(null)
    fun getNowWeather(city: String) {
        val client = OkHttpClient()
        val url = "$BASE_URL&location=$city&key=${API_KEY}"
        val request = okhttp3.Request.Builder().get().url(url).build()
        client.newCall(request).enqueue(object : okhttp3.Callback {
            override fun onFailure(call: okhttp3.Call, e: IOException) {
                dLog("请求失败")
            }
            override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                val json = response.body?.string()
                val weatherBean = Gson().fromJson(json!!, NowWeatherBean::class.java)
                dLog(weatherBean.toString())
                result.value = weatherBean
                dLog("result: $result")
            }
        })
    }
    fun dLog(msg: String) {
        Log.d("NowWeatherModel", msg)
    }
}