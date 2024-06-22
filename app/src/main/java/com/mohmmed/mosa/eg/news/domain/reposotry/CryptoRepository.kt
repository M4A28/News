package com.mohmmed.mosa.eg.news.domain.reposotry

import androidx.paging.PagingData
import com.mohmmed.mosa.eg.news.domain.module.crypto.Coin
import kotlinx.coroutines.flow.Flow

interface CryptoRepository {

    fun getGlobal()

    fun getTickers(start: Int, limit: Int): Flow<PagingData<Coin>>

}