package com.mohmmed.mosa.eg.news.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mohmmed.mosa.eg.news.domain.module.news.Article
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article)

    @Delete
    suspend fun delete(article: Article)

    @Query("SELECT * FROM article")
    fun getArticles(): Flow<List<Article>>

    @Query("SELECT * FROM article WHERE title LIKE '%' ||:title||'%' ")
    fun getArticleByTitle(title: String): Flow<List<Article>>

    @Query("SELECT * FROM article WHERE url = :url")
    suspend fun getArticleByUrl(url: String): Article?





}