package com.mohmmed.mosa.eg.news.presention.detailse

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohmmed.mosa.eg.news.R
import com.mohmmed.mosa.eg.news.domain.module.news.Article
import com.mohmmed.mosa.eg.news.domain.usecase.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val newsUseCase: NewsUseCases
): ViewModel() {

    var sideEffect by mutableStateOf<Int?>(null)
        private set

    fun onEvent(event: DetailsEvent){
        when(event){
            is DetailsEvent.UpsertDeleteArticle -> {
                viewModelScope.launch {
                    val article = newsUseCase.selectArticle(event.article.url)
                    if(article == null){
                        upsertArticle(event.article)
                    }
                    else{
                        deleteArticle(event.article)
                    }
                }
            }
            is DetailsEvent.RemoveSideEffect -> {
                sideEffect = null
            }
        }
    }

    private suspend fun deleteArticle(article: Article) {
        newsUseCase.deleteArticle(article)
        sideEffect = R.string.article_deleted

    }

    private suspend fun upsertArticle(article: Article) {
        newsUseCase.upsertArticle(article)
        sideEffect = R.string.article_inserted
    }
}