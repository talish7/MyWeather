package com.tian.myweather.ui.view

import android.net.Proxy
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tian.myweather.R
import com.tian.myweather.ui.widgets.DropdownMenuSample

/**
 * @Author: tian7
 * @Email: 253493510@qq.com
 * @Date: on 2024/7/12: 22: 49
 * @Description: 描述
 */
@Composable
fun HomePage() {
    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.tmp_bg ),
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
                DropdownMenuSample()
                Spacer(modifier = Modifier.size(20.dp))
                Row(verticalAlignment = Alignment.CenterVertically){
                    Text(text = "北京", fontSize = 30.sp, color = Color.White)
                    Icon(imageVector = Icons.Filled.LocationOn, contentDescription = null, tint = Color.White)
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "22", fontSize = 90.sp,color = Color.White)
                    Column {
                        Text(text = "℃", fontSize = 35.sp,color = Color.White)
                        Spacer(modifier = Modifier.height(30.dp))
                    }
                }
                Row(modifier = Modifier.padding(end = 25.dp), verticalAlignment = Alignment.CenterVertically) {
                    Column {
                        Text(text = "最", fontSize = 12.sp,color = Color.White)
                        Text(text = "高", fontSize = 12.sp,color = Color.White)
                    }
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "24℃", fontSize = 28.sp,color = Color.White)
                    Spacer(modifier = Modifier.width(20.dp))
                    Column {
                        Text(text = "最", fontSize = 12.sp,color = Color.White)
                        Text(text = "低", fontSize = 12.sp,color = Color.White)
                    }
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "22℃", fontSize = 28.sp,color = Color.White)
                }
                Spacer(modifier = Modifier.size(10.dp))
                Row{
                    Text(text = "多云", fontSize = 20.sp,color = Color.White)
                    Spacer(modifier = Modifier.width(20.dp))
                }
                Spacer(modifier = Modifier.size(20.dp))
                Box {
                    LazyRow {

                    }
                }

            }
        }
    }

}
