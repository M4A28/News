package com.mohmmed.mosa.eg.news.presention.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mohmmed.mosa.eg.news.R
import com.mohmmed.mosa.eg.news.domain.module.news.Article
import com.mohmmed.mosa.eg.news.domain.module.news.Source
import com.mohmmed.mosa.eg.news.presention.Dimens.ArticleImageSize
import com.mohmmed.mosa.eg.news.presention.Dimens.ExtraSmallPadding
import com.mohmmed.mosa.eg.news.presention.Dimens.ExtraSmallPadding2
import com.mohmmed.mosa.eg.news.presention.Dimens.SmallIconSize
import com.mohmmed.mosa.eg.news.ui.theme.CairoFont
import com.mohmmed.mosa.eg.news.util.prettyTime
import com.mohmmed.mosa.eg.news.util.stringToDate

@Composable
fun ArticleCard(
    modifier: Modifier = Modifier,
    article: Article,
    onClick: () -> Unit
    ){
    val context = LocalContext.current

    Row(modifier = modifier
        .clickable { onClick() }
        .fillMaxWidth()) {
        AsyncImage(
            modifier = Modifier
                .size(ArticleImageSize)
                .clip(MaterialTheme.shapes.medium),
            contentScale = ContentScale.Crop,
            model = ImageRequest
                .Builder(context)
                .data(article.urlToImage)
                .build(), contentDescription = null
        )

        Column(modifier = Modifier
            .padding(horizontal = ExtraSmallPadding)
            .height(ArticleImageSize),
            verticalArrangement = Arrangement.SpaceBetween) {
            Text(
                fontFamily = CairoFont,
                text = article.title,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                color = colorResource(id = R.color.text_title),
                overflow = TextOverflow.Ellipsis,
                maxLines = 2
            )
            Row(verticalAlignment = Alignment.CenterVertically){
                Text(
                    fontFamily = CairoFont,
                    text = article.source!!.name,
                    style = MaterialTheme.typography.labelMedium,
                    color = colorResource(id = R.color.text_medium),
                )
                Spacer(modifier = Modifier.width(ExtraSmallPadding2))
                Row(horizontalArrangement = Arrangement.End) {

                    Icon(
                        modifier = Modifier.size(SmallIconSize),
                        tint = colorResource(id = R.color.body),
                        painter = painterResource(id = R.drawable.ic_clock),
                        contentDescription = null
                    )

                    Spacer(modifier = Modifier.width(ExtraSmallPadding2))

                    Text(
                        fontFamily = CairoFont,
                        text = prettyTime(stringToDate(article.publishedAt)),
                        style = MaterialTheme.typography.labelSmall,
                        color = colorResource(id = R.color.text_medium),
                    )
                }
            }

        }

    }

}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun ArticalCardPreView() {
    ArticleCard(
    article = Article(
        author = "oporteat",
        content = "viverra",
        description = "error",
        publishedAt = "2 h",
        source = Source(
            id = "lorem",
            name = "Allie Clark"
        ),
        title = "e dgdf dghhtbryyyyyyjyyfgbdbd rrrrrtgryd  fsfsdsfnsdkb jhbjsbdg<bs jhbsjbdvjh bjsbjh b kbdhbgfhbj bxbjhbjhfjb bkkkj;dsk pqo;d rhthyrhccrtrtr ffff",
        url = "",
        urlToImage = ""
    ) ,
    ){

    }

}