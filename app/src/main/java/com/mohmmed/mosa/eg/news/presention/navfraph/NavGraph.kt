package com.mohmmed.mosa.eg.news.presention.navfraph

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import androidx.paging.compose.collectAsLazyPagingItems
import com.mohmmed.mosa.eg.news.presention.home.HomeScreen
import com.mohmmed.mosa.eg.news.presention.home.HomeViewModule
import com.mohmmed.mosa.eg.news.presention.news_navigator.NewsNavigator
import com.mohmmed.mosa.eg.news.presention.onbording.OnBoardingScreen
import com.mohmmed.mosa.eg.news.presention.onbording.OnBoardingViewmodel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination ){

        // onboarding route
        navigation(
            route = Route.AppStartNavigation.rout,
            startDestination = Route.OnBoardingScreen.rout
        ){
            composable(
                route = Route.OnBoardingScreen.rout
            ){
                val viewModel: OnBoardingViewmodel = hiltViewModel()
                OnBoardingScreen(viewModel::onEvent)
            }
        }

        navigation(
            route = Route.NewsNavigation.rout,
            startDestination = Route.NewsNavigationScreen.rout
        ){
            composable(
                route = Route.NewsNavigationScreen.rout
            ){
                NewsNavigator()
            }
        }
    }
}