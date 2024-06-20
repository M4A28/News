package com.mohmmed.mosa.eg.news.domain.usecase.news

import com.mohmmed.mosa.eg.news.data.local.NewsDAO
import com.mohmmed.mosa.eg.news.domain.module.Article
import com.mohmmed.mosa.eg.news.domain.reposotry.NewsRepository
import kotlinx.coroutines.flow.Flow

class SelectArticles(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(): Flow<List<Article>> {
        return newsRepository.selectArticles()
    }
}
