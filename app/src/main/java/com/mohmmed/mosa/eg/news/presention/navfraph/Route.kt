package com.mohmmed.mosa.eg.news.presention.navfraph

sealed class Route(val rout: String) {

    object OnBoardingScreen: Route(rout = "onBoardingScreen")
    object HomeScreen: Route(rout = "homeScreen")
    object SearchScreen: Route(rout = "searchScreen")
    object BookmarkScreen: Route(rout = "bookmarkScreen")
    object DetailsScreen: Route(rout = "detailsScreen")
    object AppStartNavigation: Route(rout = "appStartNavigation")
    object NewsNavigation: Route(rout = "newsNavigation")
    object NewsNavigationScreen: Route(rout = "newsNavigationScreen")
    object CryptoScreen: Route(rout = "cryptoScreen")
    object CryptoDetailsScreen: Route(rout = "cryptoDetailsScreen")


}