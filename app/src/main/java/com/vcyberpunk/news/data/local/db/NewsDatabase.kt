package com.vcyberpunk.news.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vcyberpunk.news.data.local.entity.ArticleDbModel
import com.vcyberpunk.news.data.local.entity.SubscriptionDbModel


@Database(
    entities = [ArticleDbModel::class, SubscriptionDbModel::class],
    version = 1,
    exportSchema = false
)
abstract class NewsDatabase: RoomDatabase() {

    abstract fun newsDao(): NewsDao

}