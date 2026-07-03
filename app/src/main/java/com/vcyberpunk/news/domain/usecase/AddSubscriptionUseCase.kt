package com.vcyberpunk.news.domain.usecase

import com.vcyberpunk.news.domain.repository.NewsRepository
import com.vcyberpunk.news.domain.repository.SettingsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddSubscriptionUseCase @Inject constructor(
    private val newsRepository: NewsRepository,
    private val settingsRepository: SettingsRepository
) {

    suspend operator fun invoke(topic: String) {
        newsRepository.addSubscription(topic)
        CoroutineScope(currentCoroutineContext()).launch {
            val settings = settingsRepository.getSettings().first()
            val language = settings.language
            newsRepository.updateArticlesForTopic(topic, language)
        }
    }

}