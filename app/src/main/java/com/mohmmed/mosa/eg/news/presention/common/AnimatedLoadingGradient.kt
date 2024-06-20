package com.mohmmed.mosa.eg.news.presention.common

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.mohmmed.mosa.eg.news.R
import com.mohmmed.mosa.eg.news.presention.Dimens.ArticleImageSize
import com.mohmmed.mosa.eg.news.presention.Dimens.ExtraSmallPadding
import com.mohmmed.mosa.eg.news.presention.Dimens.IndicatorSize
import com.mohmmed.mosa.eg.news.presention.Dimens.MediumPadding1

@Composable
fun AnimatedArticleCardLoading(
    modifier: Modifier = Modifier,
    primaryColor: Color = colorResource(id = R.color.shimmer),
    containerColor: Color = colorResource(id = R.color.placeholder)
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = modifier
                .size(ArticleImageSize)
                .clip(MaterialTheme.shapes.medium)
                .fillMaxWidth()
                .animatedGradient(
                    primaryColor = primaryColor,
                    containerColor = containerColor
                )
        )

        Column(modifier = Modifier
            .padding(horizontal = ExtraSmallPadding)
            .height(ArticleImageSize),
            verticalArrangement = Arrangement.SpaceBetween) {
            Box(
                modifier = Modifier
                    .height(IndicatorSize)
                    .fillMaxWidth()
                    .animatedGradient(
                        primaryColor = primaryColor,
                        containerColor = containerColor
                    )
            )
            Box(
                modifier = Modifier
                    .height(IndicatorSize)
                    .fillMaxWidth()
                    .animatedGradient(
                        primaryColor = primaryColor,
                        containerColor = containerColor
                    )
            )

                Box(
                    modifier = Modifier
                        .height(IndicatorSize)
                        .fillMaxWidth(fraction = 0.4f)
                        .animatedGradient(
                            primaryColor = primaryColor,
                            containerColor = containerColor
                        )
                )
            }

        }
}

@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun AnimatedArticleCardLoadingPreview() {
    AnimatedArticleCardLoading()
}
