package com.tian.myweather.ui.widgets

import androidx.compose.foundation.background
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
import androidx.compose.ui.unit.dp
import com.tian.myweather.data.CityMap
import com.tian.myweather.ui.viewmodel.DayWeatherModel
import com.tian.myweather.ui.viewmodel.TimeWeatherModel

/**
 * @Author: tian7
 * @Email: 253493510@qq.com
 * @Date: on 2024/7/12: 23: 06
 * @Description: 描述
 */
@Composable
fun DropdownMenuSample (modifier: Modifier,dayWeatherModel: DayWeatherModel,timeWeatherModel: TimeWeatherModel){

    var expanded by remember { mutableStateOf(false) }
    val cityMap = CityMap.getCityMap()
    var selectedId by remember { dayWeatherModel.cityId }
    LaunchedEffect(selectedId) {
        dayWeatherModel.getDayWeather(selectedId)
        timeWeatherModel.getTimeWeather(selectedId)
        dayWeatherModel.cityName.value = cityMap[selectedId]!!
    }
        Box {
            Row(
                modifier = Modifier.padding(start = 10.dp, top = 30.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = cityMap[selectedId]!!, color = Color.White)
                Spacer(modifier = Modifier.size(50.dp))
                IconButton(
                    onClick = {
                        expanded = true
                    }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowDropDown,
                        contentDescription = "Dropdown",
                        tint = Color.White
                    )
                }

                Spacer(modifier = Modifier.weight(1f))
                IconButton(
                    onClick = {
                        expanded = true
                    },
                    modifier = Modifier.padding(end = 10.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Settings,
                        contentDescription = "Dropdown",
                        tint = Color.White
                    )
                }

            }
            Column(modifier = Modifier.background(Color.Transparent)){
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = {
                            expanded = false
                        },
                        modifier = Modifier
                            .width(IntrinsicSize.Min)
                            .background(Color.Transparent),
                    ) {
                        Spacer(modifier = Modifier.height(30.dp))
                        cityMap.forEach {
                            DropdownMenuItem(
                                text = { Text(text = it.value, color = Color.Black) },
                                onClick = {
                                    selectedId = it.key
                                    dayWeatherModel.cityId.value = it.key
                                    timeWeatherModel.cityId.value = it.key
                                    expanded = false
                                },

                            )
                        }
                    }
                }

            }







}


