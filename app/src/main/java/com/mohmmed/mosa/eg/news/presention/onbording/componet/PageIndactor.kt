package com.mohmmed.mosa.eg.news.presention.onbording.componet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.mohmmed.mosa.eg.news.presention.Dimens.IndicatorSize
import com.mohmmed.mosa.eg.news.ui.theme.DarkGrey
import com.mohmmed.mosa.eg.news.ui.theme.PrimaryColor

@Composable
fun PageIndicator(
    modifier: Modifier = Modifier,
    pageSize: Int,
    selectedPage: Int,
    selectedColor: Color = PrimaryColor,
    unselectedColor: Color = DarkGrey
    ) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceBetween) {
        repeat(pageSize) { page ->
            Box(modifier = Modifier
                .size(IndicatorSize)
                .clip(CircleShape)
                .background(if(page == selectedPage) selectedColor else unselectedColor)
            )
        }

    }

}