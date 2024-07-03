package com.mohmmed.mosa.eg.news.presention.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import com.mohmmed.mosa.eg.news.domain.connectivity.ConnectionState
import com.mohmmed.mosa.eg.news.domain.module.news.Article
import com.mohmmed.mosa.eg.news.presention.Dimens.MediumPadding1
import com.mohmmed.mosa.eg.news.presention.common.ArticleList
import com.mohmmed.mosa.eg.news.presention.common.ConnectivityStatus
import com.mohmmed.mosa.eg.news.presention.common.SearchBar
import com.mohmmed.mosa.eg.news.presention.common.connectivityState


@Composable
fun SearchScreen(
    state: SearchState,
    event: (SearchEvent) -> Unit,
    navigate: (Article) -> Unit

) {
    val connection by connectivityState()
    Column(
        modifier = Modifier
            //.padding(top = MediumPadding1, start = MediumPadding1, end = MediumPadding1)
            .statusBarsPadding()
            .fillMaxSize()
    ) {
        ConnectivityStatus(connection === ConnectionState.Available)
        SearchBar(
            text = state.searchQuery,
            readOnly = false,
            onValueChange = { event(SearchEvent.UpdateSearchQuery(it)) },
            onSearch = {
                event(SearchEvent.SearchNews)
            }
        )
        Spacer(modifier = Modifier.height(MediumPadding1))
        state.articles?.let {
            val articles = it.collectAsLazyPagingItems()
            ArticleList(
                articles = articles,
                onClick = {
                    navigate(it)
                }
            )
        }
    }
}

