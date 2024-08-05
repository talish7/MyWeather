package com.tian.myweather.data.bean

import com.google.gson.annotations.SerializedName

/**
 * @Author: tian7
 * @Email: 253493510@qq.com
 * @Date: on 2024/8/2: 22: 57
 * @Description: 描述
 */
data class AirBean(
   @SerializedName("code")
   val code: String? = null,

   @SerializedName("now")
   val nowAir: NowAirBean? = null,


)
