package com.tian.myweather.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tian.myweather.ui.view.main.MainPage
import com.tian.myweather.ui.view.home.HomePage
import com.tian.myweather.ui.view.web.WebPage

/**
 * @Author: tian7
 * @Email: 253493510@qq.com
 * @Date: on 2024/8/3: 11: 38
 * @Description: 路由
 */
@Composable
fun NavGraph(navHostController: NavHostController, paddingValues: PaddingValues) {
    NavHost(
        navController = navHostController,
        startDestination = Route.HOME,
        modifier = Modifier.padding(paddingValues)
    ){
        composable(Route.MAIN){
            MainPage(navHostController)
        }
        composable(Route.HOME){
            HomePage(navHostController)
        }
        composable(Route.WEB){
            WebPage(navHostController)
        }

    }
}
