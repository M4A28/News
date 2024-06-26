package com.mohmmed.mosa.eg.news.domain.usecase.news

import androidx.paging.PagingData
import com.mohmmed.mosa.eg.news.domain.module.news.Article
import com.mohmmed.mosa.eg.news.domain.reposotry.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val newRepository: NewsRepository
) {
    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> {
        return newRepository.getNews(sources)
    }
}