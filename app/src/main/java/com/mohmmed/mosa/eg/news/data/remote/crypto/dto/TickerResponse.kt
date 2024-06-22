package com.mohmmed.mosa.eg.news.data.remote.crypto.dto


import com.google.gson.annotations.SerializedName
import com.mohmmed.mosa.eg.news.domain.module.crypto.Coin
import com.mohmmed.mosa.eg.news.domain.module.crypto.Info

data class TickerResponse(
    @SerializedName("data")
    val data: List<Coin>,
    @SerializedName("info")
    val info: Info
)