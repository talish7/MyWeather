package com.tian.myweather.data

import com.tian.myweather.config.Config.WEATHER_URL
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.internal.cache.CacheInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * @Author: tian7
 * @Email: 253493510@qq.com
 * @Date: on 2024/7/31: 20: 44
 * @Description: 描述
 */
object RetrofitManager {

    /** OkHttpClient相关配置 */
    private val client: OkHttpClient
        get() = OkHttpClient.Builder()
            .build()

    /**
     * Retrofit相关配置
     */
    fun <T> getService(serviceClass: Class<T>, baseUrl: String? = null): T {
        return Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl ?: WEATHER_URL)
            .build()
            .create(serviceClass)
    }
}