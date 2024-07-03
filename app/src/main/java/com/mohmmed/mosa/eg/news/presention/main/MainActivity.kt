package com.mohmmed.mosa.eg.news.presention.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.mohmmed.mosa.eg.news.data.local.NewsDAO
import com.mohmmed.mosa.eg.news.presention.navfraph.NavGraph
import com.mohmmed.mosa.eg.news.ui.theme.NewsTheme
import com.mohmmed.mosa.eg.news.util.prettyTime
import com.mohmmed.mosa.eg.news.util.stringToDate
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val viewModel by viewModels<MainViewModel>()
//    @Inject
//    lateinit var newsDao: NewsDAO
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen().apply {
            setKeepOnScreenCondition{
                viewModel.splashCondition
            }
        }
        setContent {
            NewsTheme {
                val startDestination = viewModel.startDestination
                NavGraph(startDestination = startDestination)
            }
        }
    }
}

