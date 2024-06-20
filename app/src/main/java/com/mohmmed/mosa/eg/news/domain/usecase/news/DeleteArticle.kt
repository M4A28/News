package com.mohmmed.mosa.eg.news.domain.usecase.news

import com.mohmmed.mosa.eg.news.data.local.NewsDAO
import com.mohmmed.mosa.eg.news.domain.module.Article
import com.mohmmed.mosa.eg.news.domain.reposotry.NewsRepository

class DeleteArticle(
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke(article: Article) {
        newsRepository.deleteArticle(article)
    }
}