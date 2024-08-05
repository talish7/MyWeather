package com.tian.myweather.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tian.myweather.data.bean.NowAirBean

/**
 * @Author: tian7
 * @Email: 253493510@qq.com
 * @Date: on 2024/8/1: 21: 57
 * @Description: 描述
 */
@Composable
fun AirQualityPage(modifier: Modifier,air: NowAirBean?) {
    Column {
        Text("空气质量",color = Color.White, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(5.dp))
        Surface(
            modifier = modifier, color = Color.Gray,
            shape =  RoundedCornerShape(20.dp)

        ){
            Column(verticalArrangement = Arrangement.Center,
                   modifier = Modifier.padding(10.dp)
                ) {
                ShowAqi(value = air?.aqi?.toInt() ?: 0, maxValue = 500)
                Text("AQI:${air?.aqi ?: "0"}",color = Color.White, fontSize = 15.sp)
                Text(text = "${air?.quality ?: ""}",color = Color.White, fontSize = 15.sp)
            }
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
                ) {
                Row {

                    Column {
                        Text("PM2.5",color = Color.White)
                        Spacer(modifier = Modifier.height(5.dp))
                        Text("SO2",color = Color.White)
                        Spacer(modifier = Modifier.height(5.dp))
                        Text("O3",color = Color.White)
                    }
                    Spacer(modifier = Modifier.size(20.dp))
                    Column {
                        Text("${air?.pm2p5 ?: "0"}",color = Color.White)
                        Spacer(modifier = Modifier.height(5.dp))
                        Text("${air?.so2 ?: "0"}",color = Color.White)
                        Spacer(modifier = Modifier.height(5.dp))
                        Text("${air?.o3 ?: "0"}",color = Color.White)
                    }
                    Spacer(modifier = Modifier.size(20.dp))
                    Column {
                        Text("PM10",color = Color.White)
                        Spacer(modifier = Modifier.height(5.dp))
                        Text("NO2",color = Color.White)
                        Spacer(modifier = Modifier.height(5.dp))
                        Text("CO",color = Color.White)
                    }
                    Spacer(modifier = Modifier.size(20.dp))
                    Column {
                        Text("${air?.pm10 ?: "0"}",color = Color.White)
                        Spacer(modifier = Modifier.height(5.dp))
                        Text("${air?.no2 ?: "0"}",color = Color.White)
                        Spacer(modifier = Modifier.height(5.dp))
                        Text("${air?.co ?: "0"}",color = Color.White)
                    }

                }
            }

        }
    }

}




