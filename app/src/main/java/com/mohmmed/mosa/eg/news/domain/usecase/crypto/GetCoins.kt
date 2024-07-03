package com.mohmmed.mosa.eg.news.domain.usecase.crypto

import androidx.paging.PagingData
import com.mohmmed.mosa.eg.news.domain.module.crypto.Coin
import com.mohmmed.mosa.eg.news.domain.reposotry.CryptoRepository
import kotlinx.coroutines.flow.Flow

class GetCoins(
    private val cryptoRepository: CryptoRepository
) {
    operator fun invoke(start: Int, limit: Int): Flow<PagingData<Coin>> {
        return cryptoRepository.getTickers(start,limit )
    }
}