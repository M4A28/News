package com.mohmmed.mosa.eg.news.domain.module.crypto


import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("coins_num")
    val coinsNum: Int,
    @SerializedName("time")
    val time: Int
)