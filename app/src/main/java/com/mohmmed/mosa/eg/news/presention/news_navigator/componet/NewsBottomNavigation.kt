package com.mohmmed.mosa.eg.news.presention.news_navigator.componet

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mohmmed.mosa.eg.news.R
import com.mohmmed.mosa.eg.news.presention.Dimens.IconSize1
import com.mohmmed.mosa.eg.news.presention.Dimens.MediumPadding3
import com.mohmmed.mosa.eg.news.presention.Dimens.SmallPadding
import com.mohmmed.mosa.eg.news.ui.theme.BackgroundColor
import com.mohmmed.mosa.eg.news.ui.theme.CairoFont
import com.mohmmed.mosa.eg.news.ui.theme.NewsTheme
import com.mohmmed.mosa.eg.news.ui.theme.PrimaryColor
import com.mohmmed.mosa.eg.news.ui.theme.PrimaryVariantColor
import com.mohmmed.mosa.eg.news.ui.theme.SecondaryVariantColor
import com.mohmmed.mosa.eg.news.ui.theme.SurfaceColor

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
            .padding(vertical = MediumPadding3, horizontal = SmallPadding)
            .clip(RoundedCornerShape(MediumPadding3)),
        containerColor = PrimaryVariantColor,
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
                    selectedIconColor = SecondaryVariantColor,
                    selectedTextColor = BackgroundColor,
                    unselectedIconColor = SurfaceColor,
                    indicatorColor = PrimaryColor,
                    unselectedTextColor = SurfaceColor),
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


