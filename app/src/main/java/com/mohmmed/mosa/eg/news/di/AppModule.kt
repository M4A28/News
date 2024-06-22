package com.mohmmed.mosa.eg.news.di

import android.app.Application
import androidx.room.Room
import com.mohmmed.mosa.eg.news.data.local.NewsDAO
import com.mohmmed.mosa.eg.news.data.local.NewsDatabase
import com.mohmmed.mosa.eg.news.data.local.NewsTypeConverter
import com.mohmmed.mosa.eg.news.data.manger.LocalUserMangerImpl
import com.mohmmed.mosa.eg.news.data.remote.crypto.CryptoApi
import com.mohmmed.mosa.eg.news.data.remote.news.NewsApi
import com.mohmmed.mosa.eg.news.data.reposotry.NewsRepositoryImp
import com.mohmmed.mosa.eg.news.domain.manger.LocalUserManger
import com.mohmmed.mosa.eg.news.domain.reposotry.NewsRepository
import com.mohmmed.mosa.eg.news.domain.usecase.app_entry.AppEntryUseCases
import com.mohmmed.mosa.eg.news.domain.usecase.app_entry.ReadAppEntry
import com.mohmmed.mosa.eg.news.domain.usecase.app_entry.SaveAppEntry
import com.mohmmed.mosa.eg.news.domain.usecase.news.DeleteArticle
import com.mohmmed.mosa.eg.news.domain.usecase.news.GetNews
import com.mohmmed.mosa.eg.news.domain.usecase.news.NewsUseCases
import com.mohmmed.mosa.eg.news.domain.usecase.news.SearchNewsUseCases
import com.mohmmed.mosa.eg.news.domain.usecase.news.SelectArticle
import com.mohmmed.mosa.eg.news.domain.usecase.news.SelectArticles
import com.mohmmed.mosa.eg.news.domain.usecase.news.UpsertArticle
import com.mohmmed.mosa.eg.news.util.Constant.CRYPTO_BASE_URL
import com.mohmmed.mosa.eg.news.util.Constant.NEWS_BASE_URL
import com.mohmmed.mosa.eg.news.util.Constant.NEWS_DB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManger(
        application: Application
    ): LocalUserManger = LocalUserMangerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManger: LocalUserManger): AppEntryUseCases = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManger),
        saveAppEntry = SaveAppEntry(localUserManger)
        )

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        return Retrofit
            .Builder()
            .baseUrl(NEWS_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCryptoApi(): CryptoApi {
        return Retrofit
            .Builder()
            .baseUrl(CRYPTO_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CryptoApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi,
        newsDao: NewsDAO
    ): NewsRepository = NewsRepositoryImp(newsApi, newsDao)

    @Provides
    @Singleton
    fun provideNewsUseCases(newsRepository:NewsRepository): NewsUseCases{
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNewsUseCases(newsRepository),
            upsertArticle = UpsertArticle(newsRepository),
            deleteArticle = DeleteArticle(newsRepository),
            selectArticle = SelectArticle(newsRepository),
            selectArticles = SelectArticles(newsRepository)
        )
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(application: Application): NewsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = NEWS_DB
        ).addTypeConverter(NewsTypeConverter())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDAO(newsDatabase: NewsDatabase):NewsDAO {
        return newsDatabase.newsDao
    }
}