package com.tian.myweather.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tian.myweather.R
import com.tian.myweather.ui.viewmodel.DayWeatherModel
import com.tian.myweather.ui.viewmodel.TimeWeatherModel
import com.tian.myweather.ui.widgets.DropdownMenuSample
import com.tian.myweather.utils.DateUtils
import kotlin.text.Typography.tm

/**
 * @Author: tian7
 * @Email: 253493510@qq.com
 * @Date: on 2024/7/12: 22: 49
 * @Description: 描述
 */
@Composable
fun MainPage(
    dayWeatherModel: DayWeatherModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    timeWeatherModel: TimeWeatherModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    var result by remember {
        dayWeatherModel.result
    }
    var tempMin by remember {
        dayWeatherModel.tempMin
    }
    var tempMax by remember {
        dayWeatherModel.tempMax
    }
    var cityName by remember {
        dayWeatherModel.cityName
    }
    var todayWeather by remember {
        dayWeatherModel.todayWeather
    }

    var timeResult by remember {
        timeWeatherModel.result
    }

    LaunchedEffect(Unit) {
        dayWeatherModel.getDayWeather("101010100")
        timeWeatherModel.getTimeWeather("101010100")
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.tmp_bg),
            contentDescription = "bg",
            modifier = Modifier.fillMaxSize()
        )
        Box {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                DropdownMenuSample(
                    modifier = Modifier.fillMaxWidth(),
                    dayWeatherModel,
                    timeWeatherModel
                )
                Spacer(modifier = Modifier.size(20.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = cityName, fontSize = 30.sp, color = Color.White)
                    Icon(
                        imageVector = Icons.Filled.LocationOn,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "22", fontSize = 90.sp, color = Color.White)
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
                    Text(text = "${tempMax}℃", fontSize = 28.sp, color = Color.White)
                    Spacer(modifier = Modifier.width(20.dp))
                    Column {
                        Text(text = "最", fontSize = 12.sp, color = Color.White)
                        Text(text = "低", fontSize = 12.sp, color = Color.White)
                    }
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "${tempMin}℃", fontSize = 28.sp, color = Color.White)
                }
                Spacer(modifier = Modifier.size(10.dp))
                Row {
                    Text(text = "$todayWeather", fontSize = 20.sp, color = Color.White)
                    Spacer(modifier = Modifier.width(20.dp))
                }
                Spacer(modifier = Modifier.size(20.dp))
                Box {
                    LazyRow {
                        timeResult?.hourly?.let {
                            items(it.size) { index ->
                                timeResult!!.hourly?.get(index)?.let {
                                    Column{
                                        if (it.time!=null){
                                            Text(
                                                text = "${DateUtils.extractTimeFromDateTimeStr(it.time!!)}",
                                                fontSize = 20.sp,
                                                color = Color.White
                                            )
                                        }
                                        Spacer(modifier = Modifier.width(10.dp))
                                        Text(
                                            text = "${it.temp}℃",
                                            fontSize = 20.sp,
                                            color = Color.White
                                        )
                                    }
                                }
                            }
                        }
                    }
                }

                    Spacer(modifier = Modifier.size(20.dp))
                    Box {
                        LazyColumn {
                            if (result?.daily != null) {
                                items(result?.daily!!.size) { index ->
                                    result?.daily!![index]?.let {
                                        Row {
                                            if (index == 0) {
                                                Text(
                                                    text = "今天",
                                                    fontSize = 30.sp,
                                                    color = Color.White
                                                )
                                            } else {
                                                Text(
                                                    text = "${DateUtils.getDayOfWeek(it.date)}",
                                                    fontSize = 30.sp,
                                                    color = Color.White
                                                )
                                            }
                                            Text(
                                                text = "${it.textDay}",
                                                fontSize = 30.sp,
                                                color = Color.White
                                            )
                                            Spacer(modifier = Modifier.width(10.dp))
                                            Text(
                                                text = " ${it.tempMin}℃",
                                                fontSize = 30.sp,
                                                color = Color.White
                                            )
                                            Spacer(modifier = Modifier.width(10.dp))
                                            Text(
                                                text = "${it.tempMax}℃",
                                                fontSize = 30.sp,
                                                color = Color.White
                                            )
                                        }
                                        Spacer(modifier = Modifier.size(30.dp))
                                    }
                                }
                            }

                        }

                    }
                }
            }
        }
}
