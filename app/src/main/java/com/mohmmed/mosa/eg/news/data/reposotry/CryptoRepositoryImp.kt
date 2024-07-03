package com.mohmmed.mosa.eg.news.data.reposotry

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.mohmmed.mosa.eg.news.data.remote.crypto.CryptoApi
import com.mohmmed.mosa.eg.news.data.remote.crypto.CryptoPagingSource
import com.mohmmed.mosa.eg.news.domain.module.crypto.Coin
import com.mohmmed.mosa.eg.news.domain.module.crypto.CryptoItem
import com.mohmmed.mosa.eg.news.domain.reposotry.CryptoRepository
import com.mohmmed.mosa.eg.news.util.Constant
import kotlinx.coroutines.flow.Flow

class CryptoRepositoryImp(
    private val cryptoApi: CryptoApi

    ): CryptoRepository {
    override fun getGlobal(): Flow<ArrayList<CryptoItem>> {
        TODO("Not yet implemented")
    }

    override fun getTickers(start: Int, limit: Int): Flow<PagingData<Coin>> {
        return Pager(
            config = PagingConfig(pageSize = Constant.PAGE_SIZE),
            pagingSourceFactory = {
                CryptoPagingSource(cryptoApi, start, limit)
            }
        ).flow
    }
}