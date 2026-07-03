package com.vcyberpunk.news.domain.usecase

import com.vcyberpunk.news.domain.repository.SettingsRepository
import javax.inject.Inject

class UpdateNotificationEnabledUseCase @Inject constructor(
    private val repository: SettingsRepository
) {

    suspend operator fun invoke(enabled: Boolean) = repository.updateNotificationsEnabled(enabled)

}