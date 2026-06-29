package com.vcyberpunk.news.di

import android.content.Context
import androidx.room.Room
import com.vcyberpunk.news.data.local.db.NewsDao
import com.vcyberpunk.news.data.local.db.NewsDatabase
import com.vcyberpunk.news.data.remote.api.NewsApiKeyInterceptor
import com.vcyberpunk.news.data.remote.api.NewsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    companion object {

        private const val DB_NAME = "NewsDatabase"

        private const val BASE_URL = "https://newsapi.org/"

        @Singleton
        @Provides
        fun provideOkHttpClient(
            newsApiKeyInterceptor: NewsApiKeyInterceptor
        ): OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(newsApiKeyInterceptor)
            .build()

        @Singleton
        @Provides
        fun provideJson(): Json = Json {
                ignoreUnknownKeys = true
                coerceInputValues = true
            }

        @Singleton
        @Provides
        fun provideConverterFactory(
            json: Json
        ): Converter.Factory = json.asConverterFactory("application/json".toMediaType())

        @Singleton
        @Provides
        fun provideRetrofit(
            okHttpClient: OkHttpClient,
            converterFactory: Converter.Factory
        ): Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .build()

        @Singleton
        @Provides
        fun provideNewsApiService(
            retrofit: Retrofit
        ): NewsApiService = retrofit.create()

        @Singleton
        @Provides
        fun provideNewsDatabase(
            @ApplicationContext context: Context
        ): NewsDatabase = Room.databaseBuilder(
            context = context,
            klass = NewsDatabase::class.java,
            name = DB_NAME
        ).build()

        @Singleton
        @Provides
        fun provideNewsDao(
            newsDatabase: NewsDatabase
        ): NewsDao = newsDatabase.newsDao()

    }

}