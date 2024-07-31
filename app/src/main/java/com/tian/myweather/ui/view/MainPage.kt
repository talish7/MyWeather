package com.tian.myweather.ui.view

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tian.myweather.R
import com.tian.myweather.ui.viewmodel.HourWeatherModel
import com.tian.myweather.ui.viewmodel.NowWeatherModel
import com.tian.myweather.ui.viewmodel.WeekWeatherModel
import com.tian.myweather.ui.widgets.DropdownMenuSample
import com.tian.myweather.utils.DateUtils
import com.tian.myweather.utils.getIconOfWeather
import kotlinx.coroutines.launch

/**
 * @Author: tian7
 * @Email: 253493510@qq.com
 * @Date: on 2024/7/12: 22: 49
 * @Description: 描述
 */
@Composable
fun MainPage(
    weekWeatherModel: WeekWeatherModel = viewModel(),
    hourWeatherModel: HourWeatherModel = viewModel(),
    nowWeatherModel: NowWeatherModel = viewModel()
) {
    //7天
//    var result by remember {
//        weekWeatherModel.result
//    }
    val result by weekWeatherModel.weekWeathers.collectAsState()

    //今天
    var tempMin by remember {
        weekWeatherModel.tempMin
    }
    var tempMax by remember {
        weekWeatherModel.tempMax
    }
    var cityName by remember {
        weekWeatherModel.cityName
    }
    var todayWeather by remember {
        weekWeatherModel.todayWeather
    }
    var icon by remember {
        weekWeatherModel.icon
    }
    //未来24小时
    var hourResult by remember {
        hourWeatherModel.result
    }
    //实时
    var nowResult by remember {
        nowWeatherModel.result
    }

    LaunchedEffect(Unit) {
        weekWeatherModel.getWeekWeather("101010100")
        hourWeatherModel.getHourWeather("101010100")
        nowWeatherModel.getNowWeather("101010100")
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.tmp_bg),
            contentDescription = "bg",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
        Box {
            Column(
                modifier = Modifier.padding(top = 30.dp, start = 20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row {
                    DropdownMenuSample(
                        modifier = Modifier,
                        weekWeatherModel = weekWeatherModel,
                        hourWeatherModel = hourWeatherModel,
                        nowWeatherModel = nowWeatherModel
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(
                        onClick = {

                        },
                        modifier = Modifier.padding(end = 20.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Settings,
                            contentDescription = "Settings",
                            tint = Color.White
                        )
                    }
                }

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
                    Text(text = "${nowResult?.now?.temp}", fontSize = 90.sp, color = Color.White)
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
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "$todayWeather", fontSize = 20.sp, color = Color.White)
                    Spacer(modifier = Modifier.width(20.dp))
                    Icon(
                        painterResource(id = getIconOfWeather(icon)),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(22.dp)
                    )
                }
                Spacer(modifier = Modifier.size(20.dp))
                Box {
                    Column {
                        Text(
                            text = "上次更新时间: ${
                                DateUtils.extractTimeFromDateTimeStr(
                                    hourResult?.hourly?.get(0)?.time.toString()
                                )
                            }", modifier = Modifier
                                .align(Alignment.End)
                                .padding(end = 20.dp, bottom = 10.dp), color = Color.White, fontSize = 12.sp
                        )
                        Divider(
                            modifier = Modifier.padding(start = 10.dp, end = 20.dp)
                        )
                        LazyRow {
                            nowResult?.now?.let {
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
                                            painterResource(id = getIconOfWeather(icon)),
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

                            hourResult?.hourly?.let {
                                items(it.size) { index ->
                                    hourResult!!.hourly?.get(index)?.let {
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
                Box {
                    Column {
                        Divider(modifier = Modifier.padding(start = 10.dp, end = 20.dp))
                        LazyRow {
                            if (result?.daily != null) {
                                items(result?.daily!!.size) { index ->
                                    result?.daily!![index]?.let {
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
                                                painterResource(id = getIconOfWeather(it.iconDay ?: " ")),
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
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 20.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
                    onClick = {
                    }) {
                    Text(text = "查看更多天气")
                }


            }
        }
    }
}
