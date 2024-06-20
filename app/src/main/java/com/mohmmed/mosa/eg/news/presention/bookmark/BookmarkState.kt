package com.mohmmed.mosa.eg.news.presention.bookmark

import com.mohmmed.mosa.eg.news.domain.module.Article

data class BookmarkState(
    val articles: List<Article> = emptyList()
)

