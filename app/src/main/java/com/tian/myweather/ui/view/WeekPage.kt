package com.tian.myweather.ui.view

import androidx.compose.foundation.layout.Box
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
import com.tian.myweather.data.bean.WeekWeatherBean
import com.tian.myweather.utils.DateUtils
import com.tian.myweather.utils.getIconOfWeather

/**
 * @Author: tian7
 * @Email: 253493510@qq.com
 * @Date: on 2024/8/1: 02: 58
 * @Description: 描述
 */
@Composable
fun WeekPage(modifier: Modifier,weekWeather: WeekWeatherBean?) {
    Box {
        Column {
            Divider(modifier = Modifier.padding(start = 10.dp, end = 20.dp))
            LazyRow {
                if (weekWeather?.daily != null) {
                    items(weekWeather?.daily!!.size) { index ->
                        weekWeather?.daily!![index]?.let {
                            Column(
                                modifier = Modifier.padding(
                                    start = 10.dp,
                                    end = 20.dp,
                                    top = 20.dp,
                                    bottom = 20.dp
                                ),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                if (index == 0) {
                                    Text(
                                        text = "今天",
                                        fontSize = 20.sp,
                                        color = Color.White
                                    )
                                } else {
                                    Text(
                                        text = "${DateUtils.getDayOfWeek(it.date)}",
                                        fontSize = 20.sp,
                                        color = Color.White
                                    )
                                }
                                Spacer(modifier = Modifier.size(10.dp))
                                Icon(
                                    painterResource(
                                        id = getIconOfWeather(
                                            it.iconDay ?: " "
                                        )
                                    ),
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(22.dp)
                                )
                                Spacer(modifier = Modifier.size(10.dp))
                                Text(
                                    text = "${it.textDay}",
                                    fontSize = 20.sp,
                                    color = Color.White
                                )
                                Spacer(modifier = Modifier.size(10.dp))
                                Text(
                                    text = " ${it.tempMin}~${it.tempMax}℃",
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
}