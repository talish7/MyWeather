package com.tian.myweather.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.I
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tian.myweather.data.CityMap
import com.tian.myweather.ui.viewmodel.HourWeatherModel
import com.tian.myweather.ui.viewmodel.NowWeatherModel
import com.tian.myweather.ui.viewmodel.WeekWeatherModel

/**
 * @Author: tian7
 * @Email: 253493510@qq.com
 * @Date: on 2024/7/12: 23: 06
 * @Description: 描述
 */
@Composable
fun DropdownMenuSample(
    modifier: Modifier,
    weekWeatherModel: WeekWeatherModel,
    hourWeatherModel: HourWeatherModel,
    nowWeatherModel: NowWeatherModel
) {

    var expanded by remember { mutableStateOf(false) }
    val cityMap = CityMap.getCityMap()
    var selectedId by remember { weekWeatherModel.cityId }

    LaunchedEffect(selectedId) {
        weekWeatherModel.getWeekWeather(selectedId)
        hourWeatherModel.getHourWeather(selectedId)
        weekWeatherModel.cityName.value = cityMap[selectedId]!!
        nowWeatherModel.getNowWeather(selectedId)
    }

    Box(modifier = modifier) {
        Row {
            Column {
                Row(
                    modifier= Modifier.clickable {
                        expanded = true
                    },
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(text = cityMap[selectedId]!!, color = Color.White, fontSize = 14.sp)
                    Spacer(modifier = Modifier.width(60.dp))
                    IconButton(onClick = { expanded = true }) {
                        Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = "Setting", tint = Color.White)
                    }
                }

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = {
                        expanded = false
                    },
                ) {
                    cityMap.forEach {
                        DropdownMenuItem(
                            text = { Text(text = it.value, color = Color.Black) },
                            onClick = {
                                selectedId = it.key
                                weekWeatherModel.cityId.value = it.key
                                hourWeatherModel.cityId.value = it.key
                                expanded = false
                            },
                        )
                    }
                }
            }
        }


    }




}


