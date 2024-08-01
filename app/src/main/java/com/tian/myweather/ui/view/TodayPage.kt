package com.tian.myweather.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tian.myweather.data.bean.DailyBean
import com.tian.myweather.data.bean.NowWeatherBean
import com.tian.myweather.utils.getIconOfWeather

/**
 * @Author: tian7
 * @Email: 253493510@qq.com
 * @Date: on 2024/8/1: 02: 47
 * @Description: 描述
 */
@Composable
fun TodayPage(modifier: Modifier,todayWeather: DailyBean?,nowWeather: NowWeatherBean?,cityName: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = cityName, fontSize = 30.sp, color = Color.White)
        Icon(
            imageVector = Icons.Filled.LocationOn,
            contentDescription = null,
            tint = Color.White
        )
    }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = "${nowWeather?.now?.temp}", fontSize = 90.sp, color = Color.White)
        Column {
            Text(text = "℃", fontSize = 35.sp, color = Color.White)
            Spacer(modifier = Modifier.height(30.dp))
        }
    }
    Row(
        modifier = Modifier.padding(end = 25.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(text = "最", fontSize = 12.sp, color = Color.White)
            Text(text = "高", fontSize = 12.sp, color = Color.White)
        }
        Spacer(modifier = Modifier.width(5.dp))
        Text(text = "${todayWeather?.tempMax}℃", fontSize = 28.sp, color = Color.White)
        Spacer(modifier = Modifier.width(20.dp))
        Column {
            Text(text = "最", fontSize = 12.sp, color = Color.White)
            Text(text = "低", fontSize = 12.sp, color = Color.White)
        }
        Spacer(modifier = Modifier.width(5.dp))
        Text(text = "${todayWeather?.tempMin}℃", fontSize = 28.sp, color = Color.White)
    }
    Spacer(modifier = Modifier.size(10.dp))
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = "${todayWeather?.textDay}", fontSize = 20.sp, color = Color.White)
        Spacer(modifier = Modifier.width(20.dp))
        Icon(
            painterResource(id = getIconOfWeather(todayWeather?.iconDay.toString())),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(22.dp)
        )
    }
}