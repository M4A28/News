package com.mohmmed.mosa.eg.news.presention.bookmark

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.mohmmed.mosa.eg.news.R
import com.mohmmed.mosa.eg.news.domain.module.news.Article
import com.mohmmed.mosa.eg.news.presention.Dimens
import com.mohmmed.mosa.eg.news.presention.Dimens.MediumPadding0
import com.mohmmed.mosa.eg.news.presention.Dimens.MediumPadding3
import com.mohmmed.mosa.eg.news.presention.common.ArticleList
import com.mohmmed.mosa.eg.news.ui.theme.CairoFont
import com.mohmmed.mosa.eg.news.ui.theme.PrimaryVariantColor
import com.mohmmed.mosa.eg.news.ui.theme.SecondaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookmarkScreen(
    state: BookmarkState,
    navigateToDetails: (Article) -> Unit
) {

    Column(modifier = Modifier
        .fillMaxSize()
        .statusBarsPadding()
        .padding(vertical = MediumPadding3, horizontal = Dimens.SmallPadding)
    ) {


        TopAppBar(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(MediumPadding3)),
            title = {
                Text(
                    fontFamily = CairoFont,
                    text = stringResource(R.string.bookmark),
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                )
            },
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = PrimaryVariantColor,
                actionIconContentColor = SecondaryColor,
                navigationIconContentColor = SecondaryColor,
                titleContentColor = Color.White
            )
        )

        Spacer(modifier = Modifier.height(MediumPadding0))
        ArticleList(
            articles = state.articles,
            onClick = { article ->
                navigateToDetails(article)
            }
        )

    }

}