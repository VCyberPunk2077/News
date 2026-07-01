package com.vcyberpunk.news.domain.usecase

import com.vcyberpunk.news.domain.repository.SettingsRepository
import javax.inject.Inject

class GetSettingsUseCase @Inject constructor(
    private val repository: SettingsRepository
) {

    operator fun invoke() = repository.getSettings()

}