package com.vcyberpunk.news.domain.usecase

import com.vcyberpunk.news.domain.repository.NewsRepository
import javax.inject.Inject

class AddSubscriptionUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) {

    suspend operator fun invoke(topic: String) {
        newsRepository.addSubscription(topic)
        newsRepository.updateArticlesForTopic(topic)
    }

}