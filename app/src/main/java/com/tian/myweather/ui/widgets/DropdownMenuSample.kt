package com.tian.myweather.ui.widgets

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * @Author: tian7
 * @Email: 253493510@qq.com
 * @Date: on 2024/7/12: 23: 06
 * @Description: 描述
 */
@Preview
@Composable
fun DropdownMenuSample (){
    var expanded by remember { mutableStateOf(false)}
    val items= listOf("Item1","Item2","Item3")
    var selectedIndex by remember{ mutableIntStateOf(0) }
    Box {
        Row(
            modifier = Modifier.padding(start = 10.dp, top = 30.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = items[selectedIndex], color = Color.White)
            Spacer(modifier = Modifier.size(50.dp))
            IconButton(
                onClick = {
                    expanded=true
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
                    expanded=true
                },
                modifier = Modifier.padding(end = 10.dp)) {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = "Dropdown",
                    tint = Color.White
                )
            }

        }


        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded=false
            }
        ){
            items.forEachIndexed{
                    index,item->
                DropdownMenuItem(
                    text = { Text(text = item) },
                    onClick = {
                        selectedIndex = index
                        expanded=false
                    }
                )
            }
        }
    }


}

