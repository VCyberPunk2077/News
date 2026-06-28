package com.vcyberpunk.news.di

import android.content.Context
import androidx.room.Room
import com.vcyberpunk.news.data.local.db.NewsDao
import com.vcyberpunk.news.data.local.db.NewsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    companion object {

        private const val DB_NAME = "NewsDatabase"

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