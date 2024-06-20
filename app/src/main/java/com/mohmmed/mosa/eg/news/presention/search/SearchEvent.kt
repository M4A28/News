package com.mohmmed.mosa.eg.news.presention.search

sealed class SearchEvent {

    data class UpdateSearchQuery(val searchQuery: String): SearchEvent()

    object SearchNews: SearchEvent()

}