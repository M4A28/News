package com.mohmmed.mosa.eg.news.presention.news_navigator.componet

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mohmmed.mosa.eg.news.R
import com.mohmmed.mosa.eg.news.presention.Dimens.ExtraSmallPadding
import com.mohmmed.mosa.eg.news.presention.Dimens.IconSize1
import com.mohmmed.mosa.eg.news.presention.Dimens.MediumPadding2
import com.mohmmed.mosa.eg.news.ui.theme.CairoFont
import com.mohmmed.mosa.eg.news.ui.theme.NewsTheme
import com.mohmmed.mosa.eg.news.ui.theme.PrimaryColor
import com.mohmmed.mosa.eg.news.ui.theme.PrimaryVariantColor

data class BottomNavigationItem(
    @DrawableRes val icon: Int,
    @StringRes val text: Int
)

@Composable
fun  NewsBottomNavigation(
    items: List<BottomNavigationItem>,
    selected: Int,
    onClick: (Int) -> Unit
    ) {

    NavigationBar(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topEnd = MediumPadding2, topStart = MediumPadding2)),
        containerColor = MaterialTheme.colorScheme.background,
        tonalElevation = 10.dp
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(selected = index == selected,
                onClick = { onClick(index) }, icon = {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = null,
                            modifier = Modifier.size(IconSize1)
                        )
                },
                label = {
                    Text(
                        fontFamily = CairoFont,
                        text = stringResource(id = item.text),
                        style = MaterialTheme.typography.labelSmall
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedTextColor = colorResource(id = R.color.body),
                    unselectedIconColor = colorResource(id = R.color.body),
                    indicatorColor = colorResource(id = R.color.bottom_indicator).copy(alpha = 0.1f),
                )
            )
        }

    }

}

@Preview(showBackground = true)
@Composable
fun BottomParagraphPreview() {
    NewsTheme {

        NewsBottomNavigation(
            items =    listOf(
                BottomNavigationItem(icon = R.drawable.ic_home, text = R.string.home),
                BottomNavigationItem(icon = R.drawable.ic_search, text = R.string.search),
                BottomNavigationItem(icon = R.drawable.ic_bookmark, text = R.string.bookmark),
            ),
            selected = 0,
            onClick = {}
        )
    }

}


