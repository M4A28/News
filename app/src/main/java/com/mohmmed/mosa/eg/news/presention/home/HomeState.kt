package com.mohmmed.mosa.eg.news.presention.home

import com.mohmmed.mosa.eg.news.presention.base.State


data class HomeState(
    val newsTicker: String = "",
    val isLoading: Boolean = false
)