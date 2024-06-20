package com.mohmmed.mosa.eg.news.presention.news_navigator

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.mohmmed.mosa.eg.news.R
import com.mohmmed.mosa.eg.news.domain.module.Article
import com.mohmmed.mosa.eg.news.presention.bookmark.BookmarkScreen
import com.mohmmed.mosa.eg.news.presention.bookmark.BookmarkViewmodel
import com.mohmmed.mosa.eg.news.presention.detailse.DetailsEvent
import com.mohmmed.mosa.eg.news.presention.detailse.DetailsScreen
import com.mohmmed.mosa.eg.news.presention.detailse.DetailsViewModel
import com.mohmmed.mosa.eg.news.presention.home.HomeScreen
import com.mohmmed.mosa.eg.news.presention.home.HomeViewModule
import com.mohmmed.mosa.eg.news.presention.navfraph.Route
import com.mohmmed.mosa.eg.news.presention.news_navigator.componet.BottomNavigationItem
import com.mohmmed.mosa.eg.news.presention.news_navigator.componet.NewsBottomNavigation
import com.mohmmed.mosa.eg.news.presention.search.SearchScreen
import com.mohmmed.mosa.eg.news.presention.search.SearchViewModel
import com.mohmmed.mosa.eg.news.util.Constant.ARTICLE_KEY

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NewsNavigator() {

    val bottomNavigationItems = remember {
        listOf(
            BottomNavigationItem(icon = R.drawable.ic_home, text = R.string.home),
            BottomNavigationItem(icon = R.drawable.ic_search, text = R.string.search),
            BottomNavigationItem(icon = R.drawable.ic_bookmark, text = R.string.bookmark)
        )
    }
    val navController = rememberNavController()
    val backStackState = navController.currentBackStackEntryAsState().value
    var selectedItem by rememberSaveable { mutableStateOf(0) }
    selectedItem =  remember(key1 = backStackState) {
        when (backStackState?.destination?.route) {
            Route.HomeScreen.rout -> 0
            Route.SearchScreen.rout -> 1
            Route.BookmarkScreen.rout -> 2
            else -> 0
        }
    }

    val showBottomBar = remember(key1 = backStackState) {
        backStackState?.destination?.route == Route.HomeScreen.rout ||
        backStackState?.destination?.route == Route.SearchScreen.rout ||
        backStackState?.destination?.route == Route.BookmarkScreen.rout

    }

    Scaffold(
        bottomBar = {
            if(showBottomBar){
                NewsBottomNavigation(
                    items = bottomNavigationItems,
                    selected = selectedItem,
                    onClick = {index ->
                        when(index){
                            0 -> navigateToTab(navController, Route.HomeScreen.rout)
                            1 -> navigateToTab(navController, Route.SearchScreen.rout)
                            2 -> navigateToTab(navController, Route.BookmarkScreen.rout)
                        }

                    })
            }
        }
    ) {
        val bottomPadding = it.calculateBottomPadding()
        NavHost(modifier = Modifier.padding(bottom = bottomPadding),
            navController = navController,
            startDestination = Route.HomeScreen.rout
        ) {

            composable(route = Route.HomeScreen.rout){
                val viewmodel: HomeViewModule = hiltViewModel()
                val articles = viewmodel.news.collectAsLazyPagingItems()
                HomeScreen(
                    articles = articles,
                    navigateToDetails = {article ->
                        navigateToDetails(navController, article)
                    },
                    navigateToSearch = {
                        navigateToTab(navController, Route.SearchScreen.rout)
                    }
                )
            }

            // TODO : Handel sideEffect
            composable(route = Route.DetailsScreen.rout){
                val viewmodel: DetailsViewModel = hiltViewModel()
                if(viewmodel.sideEffect != null){
                    Toast.makeText(
                        LocalContext.current,
                        stringResource(id = viewmodel.sideEffect!! ),
                        Toast.LENGTH_SHORT
                    ).show()
                    viewmodel.onEvent(DetailsEvent.RemoveSideEffect)
                }
                navController.previousBackStackEntry
                    ?.savedStateHandle
                    ?.get<Article?>(ARTICLE_KEY)?.let {article ->
                        DetailsScreen(
                            article = article,
                            event = viewmodel::onEvent,
                            navigateUp = {navController.navigateUp()}
                        )
                    }

            }
            composable(route = Route.SearchScreen.rout){
                val viewmodel: SearchViewModel = hiltViewModel()
                SearchScreen(state = viewmodel.state.value,
                    event = viewmodel::onEvent ,
                    navigate = {article ->
                        navigateToDetails(navController, article)
                    })

            }

            composable(route = Route.BookmarkScreen.rout){
                val viewmodel: BookmarkViewmodel = hiltViewModel()
                BookmarkScreen(state = viewmodel.state.value, navigateToDetails ={ article ->
                    navigateToDetails(navController, article)
                } )

            }


        }

    }
}

private fun navigateToTab(navController: NavController, route: String){
    navController.navigate(route = route){
        navController.graph.startDestinationRoute?.let{home ->
            popUpTo(home){
                saveState = true
            }
            restoreState = true
            launchSingleTop = true

        }
    }
}

private fun navigateToDetails(navController: NavController, article: Article){
    navController.currentBackStackEntry?.savedStateHandle?.set(ARTICLE_KEY, article)
    navController.navigate(Route.DetailsScreen.rout)
}