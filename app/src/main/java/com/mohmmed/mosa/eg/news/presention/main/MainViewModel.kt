package com.mohmmed.mosa.eg.news.presention.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohmmed.mosa.eg.news.domain.usecase.app_entry.AppEntryUseCases
import com.mohmmed.mosa.eg.news.presention.navfraph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appEntryUseCases: AppEntryUseCases
) :ViewModel() {

    var splashCondition by mutableStateOf(true)
        private set

    var startDestination by mutableStateOf(Route.NewsNavigation.rout)
        private set

    init{
        appEntryUseCases.readAppEntry().onEach { canStartFromHomeScreen ->
            if(canStartFromHomeScreen){
                startDestination = Route.NewsNavigation.rout
            }else{
                startDestination = Route.AppStartNavigation.rout
            }
            delay(250)
            splashCondition = false
        }.launchIn(viewModelScope)
    }
}