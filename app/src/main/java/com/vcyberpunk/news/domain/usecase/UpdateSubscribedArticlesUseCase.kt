package com.vcyberpunk.news.domain.usecase

import com.vcyberpunk.news.domain.repository.NewsRepository
import com.vcyberpunk.news.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class UpdateSubscribedArticlesUseCase @Inject constructor(
    private val newsRepository: NewsRepository,
    private val settingsRepository: SettingsRepository
) {

    suspend operator fun invoke(): List<String> {
        val settings = settingsRepository.getSettings().first()
        val language = settings.language
        return newsRepository.updateArticlesForAllSubscriptions(language)
    }

}