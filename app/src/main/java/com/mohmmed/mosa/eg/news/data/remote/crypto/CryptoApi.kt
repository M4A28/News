package com.mohmmed.mosa.eg.news.data.remote.crypto

import com.mohmmed.mosa.eg.news.data.remote.crypto.dto.CryptoResponse
import com.mohmmed.mosa.eg.news.data.remote.crypto.dto.TickerResponse
import com.mohmmed.mosa.eg.news.util.Constant
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoApi {


    @GET("api/global")
    suspend fun getCryptGlobal():  CryptoResponse

    @GET("api/global")
    suspend fun getTickers(
        @Query("start") start: Int = 100,
        @Query("limit") limit: Int = 100,
    ): TickerResponse

}