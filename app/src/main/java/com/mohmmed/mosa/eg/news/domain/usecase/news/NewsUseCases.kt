package com.mohmmed.mosa.eg.news.domain.usecase.news

data class NewsUseCases(
    val getNews: GetNews,
    val searchNews: SearchNewsUseCases,
    val upsertArticle: UpsertArticle,
    val deleteArticle: DeleteArticle,
    val selectArticle: SelectArticle,
    val selectArticles: SelectArticles
)
