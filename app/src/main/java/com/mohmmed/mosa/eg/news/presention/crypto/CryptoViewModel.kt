package com.mohmmed.mosa.eg.news.presention.crypto

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.mohmmed.mosa.eg.news.domain.usecase.crypto.CryptoUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CryptoViewModel @Inject constructor(
    cryptoUseCases: CryptoUseCases
) : ViewModel(){

    val crypto = cryptoUseCases
        .getCoins(100, 100)
        .cachedIn(viewModelScope)
}