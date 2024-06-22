package com.mohmmed.mosa.eg.news.presention.detailse

import com.mohmmed.mosa.eg.news.domain.module.news.Article

sealed class DetailsEvent {

    data class UpsertDeleteArticle(val article: Article) : DetailsEvent()

    object RemoveSideEffect : DetailsEvent()

}