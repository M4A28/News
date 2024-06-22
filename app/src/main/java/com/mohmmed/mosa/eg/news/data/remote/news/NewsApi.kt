package com.mohmmed.mosa.eg.news.data.remote.news

import com.mohmmed.mosa.eg.news.data.remote.news.dto.NewsResponse
import com.mohmmed.mosa.eg.news.util.Constant.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("everything")
    suspend fun getNews(
        @Query("page") page: Int,
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String = API_KEY

    ): NewsResponse

       @GET("everything")
    suspend fun searchNews(
        @Query("q") searchQuery: String,
        @Query("page") page: Int,
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String = API_KEY

    ): NewsResponse



}