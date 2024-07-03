package com.mohmmed.mosa.eg.news.presention.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import com.mohmmed.mosa.eg.news.R
import com.mohmmed.mosa.eg.news.domain.connectivity.ConnectionState
import com.mohmmed.mosa.eg.news.domain.module.news.Article
import com.mohmmed.mosa.eg.news.presention.Dimens.MediumPadding0
import com.mohmmed.mosa.eg.news.presention.Dimens.MediumPadding1
import com.mohmmed.mosa.eg.news.presention.common.ArticleList
import com.mohmmed.mosa.eg.news.presention.common.ConnectivityStatus
import com.mohmmed.mosa.eg.news.presention.common.SearchBar
import com.mohmmed.mosa.eg.news.presention.common.connectivityState
import com.mohmmed.mosa.eg.news.util.Constant.PAGE_SIZE


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    articles: LazyPagingItems<Article>,
    navigateToDetails: (Article) -> Unit,
    navigateToSearch: () -> Unit
) {

    val connection by connectivityState()
    val titles by remember {
        derivedStateOf {
            if (articles.itemCount > PAGE_SIZE) {
                articles.itemSnapshotList.items
                    .slice(IntRange(start = 0, endInclusive = PAGE_SIZE - 1))
                    .joinToString(separator = " \uD83D\uDFE5 ") { it.title }
            } else {
                ""
            }
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            //.padding(top = MediumPadding1)
            .statusBarsPadding()
    ) {
        ConnectivityStatus(connection === ConnectionState.Available)
        SearchBar(
            modifier = Modifier
                .padding(horizontal = MediumPadding1)
                .fillMaxWidth(),
            text = "",
            readOnly = true,
            onValueChange = {},
            onSearch = navigateToSearch,
            onClick = {
                navigateToSearch()
            }
        )

        Spacer(modifier = Modifier.height(MediumPadding1))

        Text(
            text = titles, modifier = Modifier
                .fillMaxWidth()
                .padding(start = MediumPadding1)
                .basicMarquee(), fontSize = 12.sp,
            color = colorResource(id = R.color.placeholder)
        )

        Spacer(modifier = Modifier.height(MediumPadding1))

        ArticleList(
            modifier = Modifier.padding(horizontal = MediumPadding0),
            articles = articles,
            onClick = { article ->
                navigateToDetails(article)
            }
        )
    }
}