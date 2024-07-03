package com.mohmmed.mosa.eg.news.presention.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.mohmmed.mosa.eg.news.domain.connectivity.ConnectionState
import com.mohmmed.mosa.eg.news.util.network.connectivityManager
import com.mohmmed.mosa.eg.news.util.network.currentConnectivityState
import com.mohmmed.mosa.eg.news.util.network.observeConnectivityAsFlow

@Composable
fun currentConnectionState(): ConnectionState {
    val connectivityManager = LocalContext.current.connectivityManager
    return remember { connectivityManager.currentConnectivityState }
}

@Composable
fun connectivityState(): State<ConnectionState> {
    val connectivityManager = LocalContext.current.connectivityManager
    return produceState(initialValue = connectivityManager.currentConnectivityState) {
        connectivityManager.observeConnectivityAsFlow().collect { value = it }
    }
}