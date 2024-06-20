package com.mohmmed.mosa.eg.news.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.mohmmed.mosa.eg.news.domain.module.Article

data class NewsResponse(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)