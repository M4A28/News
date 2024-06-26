package com.mohmmed.mosa.eg.news.data.remote.news

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mohmmed.mosa.eg.news.domain.module.news.Article

class SearchNewsPagingSource(
    val newsApi: NewsApi,
    val sources: String,
    val searchQuery: String
): PagingSource<Int, Article>() {
    private var totalNewsCount = 0

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val page = params.key ?: 1
        return try {
            val newsResponse = newsApi.searchNews(searchQuery = searchQuery, page = page, sources = sources)
            totalNewsCount += newsResponse.articles.size
            val articles = newsResponse.articles.distinctBy { it.title }
            return LoadResult.Page(
                data = articles,
                nextKey = if(totalNewsCount == newsResponse.totalResults) null else page + 1,
                prevKey = null
            )
        }catch (e: Exception){
            e.printStackTrace()
            return LoadResult.Error(throwable = e)
        }
    }
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let{ anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1)?:anchorPage?.nextKey?.minus(1)
        }
    }
}