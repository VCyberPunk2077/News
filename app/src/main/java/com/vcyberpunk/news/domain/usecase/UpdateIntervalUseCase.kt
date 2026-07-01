package com.vcyberpunk.news.domain.usecase

import com.vcyberpunk.news.domain.entity.Interval
import com.vcyberpunk.news.domain.repository.SettingsRepository
import javax.inject.Inject

class UpdateIntervalUseCase @Inject constructor(
    private val repository: SettingsRepository
) {

    suspend operator fun invoke(interval: Interval) = repository.updateInterval(interval.minutes)

}