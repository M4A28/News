package com.mohmmed.mosa.eg.news.domain.reposotry

import androidx.paging.PagingData
import com.mohmmed.mosa.eg.news.domain.module.crypto.Coin
import com.mohmmed.mosa.eg.news.domain.module.crypto.CryptoItem
import kotlinx.coroutines.flow.Flow

interface CryptoRepository {

    fun getGlobal(): Flow<ArrayList<CryptoItem>>

    fun getTickers(start: Int, limit: Int): Flow<PagingData<Coin>>

}