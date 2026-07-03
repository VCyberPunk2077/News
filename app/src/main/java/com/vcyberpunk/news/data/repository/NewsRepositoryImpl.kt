package com.vcyberpunk.news.data.repository

import android.util.Log
import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.vcyberpunk.news.data.background.RefreshDataWorker
import com.vcyberpunk.news.data.local.db.NewsDao
import com.vcyberpunk.news.data.local.entity.ArticleDbModel
import com.vcyberpunk.news.data.local.entity.SubscriptionDbModel
import com.vcyberpunk.news.data.mapper.toDbModels
import com.vcyberpunk.news.data.mapper.toEntities
import com.vcyberpunk.news.data.remote.api.NewsApiService
import com.vcyberpunk.news.domain.entity.Article
import com.vcyberpunk.news.domain.entity.RefreshConfig
import com.vcyberpunk.news.domain.repository.NewsRepository
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsApiService: NewsApiService,
    private val newsDao: NewsDao,
    private val workManager: WorkManager
) : NewsRepository {
    override fun gelAllSubscriptions(): Flow<List<String>> =
        newsDao.getAllSubscriptions().map { subscriptionDbModels ->
            subscriptionDbModels.map { it.topic }
        }

    override suspend fun addSubscription(topic: String) {
        val subscriptionDbModel = SubscriptionDbModel(topic = topic)
        newsDao.addSubscription(subscriptionDbModel)
    }

    override suspend fun updateArticlesForTopic(topic: String): Boolean {
        val articles = loadArticles(topic)
        val ids = newsDao.addArticles(articles)
        return ids.any { it != -1L }
    }

    private suspend fun loadArticles(topic: String): List<ArticleDbModel> {
        return try {
            newsApiService.loadArticles(topic).toDbModels(topic)
        } catch (e: Exception) {
            if (e is CancellationException) {
                throw e
            }
            Log.e("NewsRepositoryImpl", e.stackTraceToString())
            listOf()
        }
    }

    override suspend fun removeSubscription(topic: String) {
        val subscriptionDbModel = SubscriptionDbModel(topic = topic)
        newsDao.deleteSubscription(subscriptionDbModel)
    }

    override suspend fun updateArticlesForAllSubscriptions(): List<String> {
        val updatedTopics = mutableListOf<String>()
        val subscriptions = newsDao.getAllSubscriptions().first()
        coroutineScope {
            subscriptions.forEach {
                launch {
                    val updated = updateArticlesForTopic(it.topic)
                    if (updated) {
                        updatedTopics.add(it.topic)
                    }
                }
            }
        }
        return updatedTopics
    }

    override fun startBackgroundRefresh(refreshConfig: RefreshConfig) {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(
                if (refreshConfig.wifiOnly) {
                    NetworkType.UNMETERED
                } else {
                    NetworkType.CONNECTED
                }
            )
            .setRequiresBatteryNotLow(true)
            .build()

        val request = PeriodicWorkRequestBuilder<RefreshDataWorker>(
            repeatInterval = refreshConfig.interval.minutes.toLong(),
            repeatIntervalTimeUnit = TimeUnit.MINUTES
        ).setConstraints(constraints).build()

        workManager.enqueueUniquePeriodicWork(
            uniqueWorkName = WORK_NAME,
            existingPeriodicWorkPolicy = ExistingPeriodicWorkPolicy.CANCEL_AND_REENQUEUE,
            request = request
        )
    }

    override fun getArticlesByTopics(topics: List<String>): Flow<List<Article>> =
        newsDao.getAllArticlesByTopics(topics).map { it.toEntities() }

    override suspend fun clearAllArticles(topics: List<String>) =
        newsDao.deleteArticlesByTopic(topics)

    private companion object {

        const val WORK_NAME = "Refresh data"

    }
}