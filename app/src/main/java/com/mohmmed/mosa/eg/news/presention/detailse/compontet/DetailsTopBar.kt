package com.mohmmed.mosa.eg.news.presention.detailse.compontet

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.mohmmed.mosa.eg.news.R
import com.mohmmed.mosa.eg.news.presention.detailse.DetailsScreen
import com.mohmmed.mosa.eg.news.ui.theme.NewsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsTopBar(
    onBrowsingClick: () -> Unit,
    onShareClick: () -> Unit,
    onBookMarkClick: () -> Unit,
    onBackClick: () -> Unit,
) {
    TopAppBar(modifier = Modifier.fillMaxWidth(),
        title = { stringResource(R.string.details) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color.Transparent,
            actionIconContentColor = colorResource(id = R.color.body),
            navigationIconContentColor = colorResource(id = R.color.body),
        ),
        navigationIcon = {
            IconButton(onClick = onBackClick ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back_arrow),
                    contentDescription = null
                )
            }
        },
        actions = {
            IconButton(onClick = onBookMarkClick) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_bookmark),
                    contentDescription = null
                )
            }
            IconButton(onClick = onShareClick ) {
                Icon(
                    imageVector = Icons.Outlined.Share,
                    contentDescription = null
                )
            }
            IconButton(onClick = onBrowsingClick ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_network),
                    contentDescription = null
                )
            }

        }
    )

}

@Preview
@Composable
private fun DetailsTopAppBarPreviwe() {
    NewsTheme {
        DetailsTopBar(
            onBrowsingClick = { },
            onShareClick = { },
            onBookMarkClick = { },
            onBackClick =  { }
        )
    }
}