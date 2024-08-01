package com.tian.myweather.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tian.myweather.data.bean.HourWeatherBean
import com.tian.myweather.data.bean.NowWeatherBean
import com.tian.myweather.utils.DateUtils
import com.tian.myweather.utils.getIconOfWeather

/**
 * @Author: tian7
 * @Email: 253493510@qq.com
 * @Date: on 2024/8/1: 02: 54
 * @Description: 描述
 */
@Composable
fun HourPage(modifier: Modifier,hourWeather: HourWeatherBean?,nowWeather: NowWeatherBean?) {
    Column {
        Text(
            text = "上次更新时间: ${
                DateUtils.extractTimeFromDateTimeStr(
                    hourWeather?.hourly?.get(0)?.time.toString()
                )
            }", modifier = Modifier
                .align(Alignment.End)
                .padding(end = 20.dp, bottom = 10.dp), color = Color.White, fontSize = 12.sp
        )
        Divider(
            modifier = Modifier.padding(start = 10.dp, end = 20.dp)
        )
        LazyRow {
            nowWeather?.now?.let {
                item {
                    Column(
                        modifier = Modifier.padding(
                            start = 10.dp,
                            end = 20.dp,
                            top = 20.dp,
                            bottom = 20.dp
                        ),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "现在",
                            fontSize = 20.sp,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.size(10.dp))
                        Icon(
                            painterResource(id = getIconOfWeather(" ")),
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(22.dp)
                        )
                        Spacer(modifier = Modifier.size(10.dp))

                        Text(
                            text = "${it.temp}℃",
                            fontSize = 20.sp,
                            color = Color.White
                        )
                    }
                }
            }

            hourWeather?.hourly?.let {
                items(it.size) { index ->
                    hourWeather!!.hourly?.get(index)?.let {
                        Column(
                            modifier = Modifier.padding(20.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            if (it.time != null) {
                                Text(
                                    text = "${
                                        DateUtils.extractTimeFromDateTimeStr(
                                            it.time!!
                                        )
                                    }",
                                    fontSize = 20.sp,
                                    color = Color.White
                                )
                            }
                            Spacer(modifier = Modifier.size(10.dp))
                            Icon(
                                painterResource(id = getIconOfWeather(it.icon ?: " ")),
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(22.dp)
                            )
                            Spacer(modifier = Modifier.size(10.dp))
                            Text(
                                text = "${it.temp ?: " "}℃",
                                fontSize = 20.sp,
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
    }

}