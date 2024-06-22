package com.mohmmed.mosa.eg.news.data.reposotry

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.mohmmed.mosa.eg.news.data.local.NewsDAO
import com.mohmmed.mosa.eg.news.data.remote.news.NewsApi
import com.mohmmed.mosa.eg.news.data.remote.news.NewsPagingSource
import com.mohmmed.mosa.eg.news.data.remote.news.SearchNewsPagingSource
import com.mohmmed.mosa.eg.news.domain.module.news.Article
import com.mohmmed.mosa.eg.news.domain.reposotry.NewsRepository
import com.mohmmed.mosa.eg.news.util.Constant.NEWS_PAGE_SIZE
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImp(
    private val newsApi: NewsApi,
    private val newsDao: NewsDAO
):
    NewsRepository{
    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = NEWS_PAGE_SIZE),
            pagingSourceFactory = {
                NewsPagingSource(
                    newsApi = newsApi,
                    sources = sources.joinToString(",")
                )
            }
        ).flow
    }

    override fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = NEWS_PAGE_SIZE),
            pagingSourceFactory = {
                SearchNewsPagingSource(
                    searchQuery = searchQuery,
                    newsApi = newsApi,
                    sources = sources.joinToString(",")
                )
            }
        ).flow
    }

    override suspend fun upsertArticle(article: Article) {
        newsDao.upsert(article)
    }

    override suspend fun deleteArticle(article: Article) {
        newsDao.delete(article)
    }

    override suspend fun selectArticle(url: String): Article? {
       return newsDao.getArticleByUrl(url)
    }

    override fun selectArticles(): Flow<List<Article>> {
        return newsDao.getArticles()
    }


}