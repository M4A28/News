package com.mohmmed.mosa.eg.news.data.remote.crypto

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mohmmed.mosa.eg.news.domain.module.crypto.Coin

class CryptoPagingSource(
    val cryptoApi: CryptoApi,
    val start: Int = 100,
    val limeit: Int = 100
): PagingSource<Int, Coin>() {

    private var totalCrypto = 0
    override fun getRefreshKey(state: PagingState<Int, Coin>): Int? {
      return state.anchorPosition?.let{ anchorPosition ->
          val anchorPage = state.closestPageToPosition(anchorPosition)
          anchorPage?.prevKey?.plus(1)?:anchorPage?.nextKey?.minus(1)
      }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Coin> {

        val page = params.key ?: 1
        return try {
            val cryptoResponse =  cryptoApi.getTickers(start, limeit)
            totalCrypto += cryptoResponse.data.size
            val coins = cryptoResponse.data
            return LoadResult.Page(
                data = coins,
                nextKey = if(totalCrypto == cryptoResponse.info.coinsNum) null else page + 1,
                prevKey = null
            )
        }catch (e: Exception){
            e.printStackTrace()
            return LoadResult.Error(throwable = e)
        }
    }

}