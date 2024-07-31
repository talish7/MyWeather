package com.tian.myweather.base

/**
 * @Author: tian7
 * @Email: 253493510@qq.com
 * @Date: on 2024/8/1: 00: 08
 * @Description: 描述
 */
class UiState<T>(
    val showLoading: Boolean = false,
    var data: T? = null,
    val error: String? = null,
    val showLoadingMore: Boolean = false,
    val noMoreData: Boolean = false
)