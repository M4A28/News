package com.mohmmed.mosa.eg.news.domain.module.news


import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity("article")
data class Article(
    @SerializedName("author")
    val author: String?,
    @SerializedName("content")
    val content: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("publishedAt")
    val publishedAt: String,
    @SerializedName("source")
    val source: Source?,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    @PrimaryKey val url: String,
    @SerializedName("urlToImage")
    val urlToImage: String
): Parcelable