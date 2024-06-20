package com.mohmmed.mosa.eg.news.presention.onbording

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.mohmmed.mosa.eg.news.R

data class Page(
    @StringRes val title: Int,
    @StringRes val description: Int,
    @DrawableRes val image: Int
)

val Pages = listOf(
    Page(
        title = R.string.on_borading_titel_1,
        description = R.string.on_boarding_description_1,
        image = R.drawable.onboarding1
    ),
    Page(
        title = R.string.on_borading_titel_2,
        description = R.string.on_boarding_description_2,
        image = R.drawable.onboarding2
    ),
    Page(
        title = R.string.on_borading_titel_3,
        description = R.string.on_boarding_description_3,
        image = R.drawable.onboarding3
    ),

)
