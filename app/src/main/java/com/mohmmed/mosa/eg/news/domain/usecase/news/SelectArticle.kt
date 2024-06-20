package com.mohmmed.mosa.eg.news.domain.usecase.news

import com.mohmmed.mosa.eg.news.data.local.NewsDAO
import com.mohmmed.mosa.eg.news.domain.module.Article
import com.mohmmed.mosa.eg.news.domain.reposotry.NewsRepository
import kotlinx.coroutines.flow.Flow

class SelectArticle(
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke(url: String): Article? {
        return newsRepository.selectArticle(url)
    }
}