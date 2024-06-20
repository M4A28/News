package com.mohmmed.mosa.eg.news.domain.usecase.news

import androidx.paging.PagingData
import com.mohmmed.mosa.eg.news.domain.module.Article
import com.mohmmed.mosa.eg.news.domain.reposotry.NewsRepository
import kotlinx.coroutines.flow.Flow

class SearchNewsUseCases(
    private val newRepository: NewsRepository
) {
    operator fun invoke(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return newRepository.searchNews(searchQuery, sources)
    }
}