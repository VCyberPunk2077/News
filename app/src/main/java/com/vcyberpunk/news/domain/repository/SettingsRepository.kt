package com.vcyberpunk.news.domain.repository

import com.vcyberpunk.news.domain.entity.Language
import com.vcyberpunk.news.domain.entity.Settings
import kotlinx.coroutines.flow.Flow

interface SettingsRepository {

    fun getSettings(): Flow<Settings>

    suspend fun updateLanguage(language: Language)

    suspend fun updateInterval(minutes: Int)

    suspend fun updateNotificationsEnables(enabled: Boolean)

    suspend fun updateWifiOnlyEnables(wifiOnly: Boolean)

}