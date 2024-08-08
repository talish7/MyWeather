package com.tian.myweather.ui.view.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.tian.myweather.navigation.NavGraph

/**
 * @Author: tian7
 * @Email: 253493510@qq.com
 * @Date: on 2024/8/3: 13: 09
 * @Description: 描述
 */
//@Composable
//fun MainPage(navHostController: NavHostController) {
//    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
//    val destination = navBackStackEntry?.destination
//    Scaffold(
//        modifier = Modifier.fillMaxSize(),
//    ) {
//        NavGraph(navHostController, it)
//    }
//}