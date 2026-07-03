package com.vcyberpunk.news.domain.usecase

import com.vcyberpunk.news.domain.repository.SettingsRepository
import javax.inject.Inject

class UpdateWifiOnlyUseCase @Inject constructor(
    private val repository: SettingsRepository
) {

    suspend operator fun invoke(wifiOnly: Boolean) = repository.updateWifiOnlyEnables(wifiOnly)

}