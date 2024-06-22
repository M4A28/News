package com.mohmmed.mosa.eg.news.presention.common

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.mohmmed.mosa.eg.news.domain.module.news.Article
import com.mohmmed.mosa.eg.news.presention.Dimens.ExtraSmallPadding
import com.mohmmed.mosa.eg.news.presention.Dimens.MediumPadding1

@Composable
fun ArticleList(
    modifier: Modifier = Modifier,
    articles: LazyPagingItems<Article>,
    onClick: (Article) -> Unit
) {

    val handelPagingResult = handelPagingResult(articles)
    if(handelPagingResult){
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(MediumPadding1),
            contentPadding = PaddingValues(ExtraSmallPadding)
        ) {
            items(count = articles.itemCount){
                articles[it]?.let{article ->
                    ArticleCard(article = article, onClick = {onClick(article)})
                }
            }

        }
    }
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun ArticleList(
    modifier: Modifier = Modifier,
    articles: List<Article>,
    onClick: (Article) -> Unit
) {
    LazyColumn(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(MediumPadding1),
            contentPadding = PaddingValues(ExtraSmallPadding)
        ) {
            items(count = articles.size){
                val article = articles[it]
                    ArticleCard(article = article, onClick = {onClick(article)})
                }
            }

}


@Composable
fun handelPagingResult(
    articles: LazyPagingItems<Article>,
):Boolean {
    val loadState = articles.loadState
    val error = when{
        loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
        loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
        loadState.append is LoadState.Error -> loadState.append as LoadState.Error
        else -> null
    }
    return when{
        loadState.refresh is LoadState.Loading -> {
            LoadingArticleList()
            false
        }
        error != null -> {
            EmptyScreen()
            false
        }
        else -> {
            true
        }
    }
}

@Composable
fun LoadingArticleList() {
    Column(verticalArrangement = Arrangement.spacedBy(MediumPadding1)) {
        repeat(5){
            AnimatedArticleCardLoading(modifier = Modifier.padding(MediumPadding1))
        }

    }

}