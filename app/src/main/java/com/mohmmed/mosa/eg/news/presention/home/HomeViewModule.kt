package com.mohmmed.mosa.eg.news.presention.home

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.ConnectivityManager.TYPE_ETHERNET
import android.net.ConnectivityManager.TYPE_MOBILE
import android.net.ConnectivityManager.TYPE_WIFI
import android.net.NetworkCapabilities.TRANSPORT_CELLULAR
import android.net.NetworkCapabilities.TRANSPORT_ETHERNET
import android.net.NetworkCapabilities.TRANSPORT_WIFI
import android.os.Build
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.mohmmed.mosa.eg.news.domain.connectivity.ConnectionState
import com.mohmmed.mosa.eg.news.domain.connectivity.ConnectivityObserver
import com.mohmmed.mosa.eg.news.domain.usecase.news.NewsUseCases
import com.mohmmed.mosa.eg.news.presention.base.BaseViewModel
import com.mohmmed.mosa.eg.news.presention.main.NewsApplication
import com.mohmmed.mosa.eg.news.util.Constant.NEWS_SOURCES_ONE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModule
@Inject constructor(private val newsUseCases: NewsUseCases)
    : ViewModel() {

    val news = newsUseCases
        .getNews(sources = NEWS_SOURCES_ONE)
        .cachedIn(viewModelScope)


    //private fun setState(update: MutableNotesState.() -> Unit) = stateStore.setState(update)
    /*fun isInternetActive(): Boolean{
        val connectivityManger = getApplication<NewsApplication>()
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            val activeNetwork = connectivityManger.activeNetwork ?: return false
            val capability = connectivityManger.getNetworkCapabilities(activeNetwork) ?: return false
            return when{
                capability.hasTransport(TRANSPORT_WIFI) -> true
                capability.hasTransport(TRANSPORT_CELLULAR) -> true
                capability.hasTransport(TRANSPORT_ETHERNET) -> true
                else -> false
            }
        }
        else{
            connectivityManger.activeNetworkInfo?.run{
                return when(type){
                    TYPE_WIFI -> true
                    TYPE_MOBILE -> true
                    TYPE_ETHERNET -> true
                    else -> false
                }
            }
        }
        return false
    }*/


}