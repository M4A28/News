package com.mohmmed.mosa.eg.news.domain.reposotry

import androidx.paging.PagingData
import com.mohmmed.mosa.eg.news.domain.module.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getNews(sources: List<String>): Flow<PagingData<Article>>

    fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>>

    suspend fun upsertArticle(article: Article)

    suspend fun deleteArticle(article: Article)

    suspend fun selectArticle(url: String): Article?

    fun selectArticles(): Flow<List<Article>>




}