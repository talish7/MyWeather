package com.tian.myweather.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * @Author: tian7
 * @Email: 253493510@qq.com
 * @Date: on 2024/7/31: 21: 32
 * @Description: 描述
 */
abstract class BaseViewModel<T>: ViewModel() {
    private val _uiState = MutableStateFlow<UiState<T>>(UiState(true))
    val uiState: StateFlow<UiState<T>> = _uiState

    protected fun emitUiState(
        showLoading: Boolean = false,
        data: T? = null,
        error: String? = null,
        showLoadingMore: Boolean = false,
        noMoreData: Boolean = false
    ) {
        _uiState.value = UiState(showLoading, data, error, showLoadingMore, noMoreData)
    }

    fun launch(
        tryBlock: suspend CoroutineScope.() -> Unit,
        catchBlock: suspend CoroutineScope.() -> Unit = {},
        finallyBlock: suspend CoroutineScope.() -> Unit = {}
    ) {
        // 默认是执行在主线程，相当于launch(Dispatchers.Main)
        viewModelScope.launch {
            try {
                tryBlock()
            } catch (e: Exception) {
                catchBlock()
            } finally {
                finallyBlock()
            }
        }
    }
}