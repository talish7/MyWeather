package com.tian.myweather.ui.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * @Author: tian7
 * @Email: 253493510@qq.com
 * @Date: on 2024/8/1: 21: 12
 * @Description: 描述
 */
@Composable
fun SettingPage(
    modifier: Modifier
){
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