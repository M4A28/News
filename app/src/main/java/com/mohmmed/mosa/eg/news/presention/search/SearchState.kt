package com.mohmmed.mosa.eg.news.presention.search

import androidx.paging.PagingData
import com.mohmmed.mosa.eg.news.domain.module.Article
import kotlinx.coroutines.flow.Flow

data class SearchState(
    val searchQuery: String = "",
    val articles: Flow<PagingData<Article>>? = null
) {
}