package com.mohmmed.mosa.eg.news.presention.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.mohmmed.mosa.eg.news.domain.usecase.app_entry.AppEntryUseCases
import com.mohmmed.mosa.eg.news.domain.usecase.news.NewsUseCases
import com.mohmmed.mosa.eg.news.util.Constant.NEWS_SOURCES_ONE
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModule @Inject constructor(private val newsUseCases: NewsUseCases) : ViewModel(){

    val news = newsUseCases
        .getNews(sources = NEWS_SOURCES_ONE)
        .cachedIn(viewModelScope)


}