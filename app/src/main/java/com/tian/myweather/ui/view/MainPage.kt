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
import com.tian.myweather.data.RetrofitManager
import com.tian.myweather.data.bean.DailyBean
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
    val weekWeather by weekWeatherModel.weekWeather.collectAsState()
    //今天
    val todayWeather by weekWeatherModel.todayWeather.collectAsState()
    //未来24小时
    val hourWeather by hourWeatherModel.hourWeather.collectAsState()
    //实时
    val nowWeather by nowWeatherModel.nowWeather.collectAsState()
    //空气
    val air by weekWeatherModel.nowAir.collectAsState()

    var cityName by remember {
        weekWeatherModel.cityName
    }


    LaunchedEffect(Unit) {
        weekWeatherModel.getWeekWeather("101010100")
        hourWeatherModel.getHourWeather("101010100")
        nowWeatherModel.getNowWeather("101010100")
        weekWeatherModel.getAir("101010100")
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.tmp_bg),
            contentDescription = "bg",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
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
                SettingPage(
                    modifier = Modifier
                )
            }
            Spacer(modifier = Modifier.size(20.dp))
            TodayPage(
                modifier = Modifier,
                todayWeather = todayWeather,
                nowWeather = nowWeather,
                cityName = cityName
            )
            Spacer(modifier = Modifier.size(20.dp))
            HourPage(
                modifier = Modifier,
                hourWeather = hourWeather,
                nowWeather = nowWeather
            )
            WeekPage(
                modifier = Modifier,
                weekWeather = weekWeather
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
                onClick = {

                }) {
                Text(text = "查看更多天气")
            }

            Spacer(modifier = Modifier.size(10.dp))
            AirQualityPage(
                 modifier = Modifier
                     .fillMaxSize()
                     .padding(end = 20.dp),
                air = air
            )


        }

    }
}
