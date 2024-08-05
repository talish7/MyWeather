package com.tian.myweather.ext

import android.os.Bundle
import androidx.navigation.NavHostController
import androidx.navigation.navOptions

/**
 * @Author: tian7
 * @Email: 253493510@qq.com
 * @Date: on 2024/8/5: 22: 15
 * @Description: 描述
 */
fun NavHostController.navigateWithBundle(route: String, bundle: Bundle? = null) {
    graph.findNode(route)?.let {
        navigate(it.id, bundle)
    }
}