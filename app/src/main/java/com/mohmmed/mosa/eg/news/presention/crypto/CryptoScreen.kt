package com.mohmmed.mosa.eg.news.presention.crypto

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import com.mohmmed.mosa.eg.news.R
import com.mohmmed.mosa.eg.news.domain.module.crypto.Coin
import com.mohmmed.mosa.eg.news.presention.Dimens
import com.mohmmed.mosa.eg.news.presention.common.ArticleList
import com.mohmmed.mosa.eg.news.presention.common.SearchBar

@Composable
fun CryptoScreen(
    coins: LazyPagingItems<Coin>,
    navigateToCryptoDetails: (Coin) -> Unit
    ) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = Dimens.MediumPadding1)
            .statusBarsPadding()
    ) {

        Spacer(modifier = Modifier.height(Dimens.MediumPadding1))

    }

}