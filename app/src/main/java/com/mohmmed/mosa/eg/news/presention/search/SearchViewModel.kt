package com.mohmmed.mosa.eg.news.presention.search

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.mohmmed.mosa.eg.news.domain.usecase.news.NewsUseCases
import com.mohmmed.mosa.eg.news.util.Constant.NEWS_SOURCES_ONE
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchNewsUseCase: NewsUseCases
) : ViewModel() {

    private val _state = mutableStateOf(SearchState())
    val state: State<SearchState> = _state

    fun onEvent(event: SearchEvent){
        when(event){
            is SearchEvent.UpdateSearchQuery -> {
                _state.value = state.value.copy(searchQuery = event.searchQuery)
            }
            is SearchEvent.SearchNews -> {
                searchNews()

            }
        }
    }

    private fun searchNews() {
        val articles = searchNewsUseCase
            .searchNews(searchQuery = state.value.searchQuery,
                sources = NEWS_SOURCES_ONE
            ).cachedIn(viewModelScope)

        _state.value = state.value.copy(articles = articles)
    }
}