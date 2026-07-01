package com.vcyberpunk.news.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.vcyberpunk.news.data.mapper.toInterval
import com.vcyberpunk.news.domain.entity.Language
import com.vcyberpunk.news.domain.entity.Settings
import com.vcyberpunk.news.domain.repository.SettingsRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

private const val PREFERENCES_KEY = "settings"
private const val LANGUAGE_KEY = "language"
private const val INTERVAL_KEY = "interval"
private const val NOTIFICATIONS_ENABLED_KEY = "notifications_enabled"
private const val WIFI_ONLY_KEY = "wifi_only"

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = PREFERENCES_KEY)

class SettingsRepositoryImpl @Inject constructor(
    @param:ApplicationContext private val context: Context
) : SettingsRepository {

    private val languageKey = stringPreferencesKey(LANGUAGE_KEY)
    private val intervalKey = intPreferencesKey(INTERVAL_KEY)
    private val notificationsEnabledKey = booleanPreferencesKey(NOTIFICATIONS_ENABLED_KEY)
    private val wifiOnlyKey = booleanPreferencesKey(WIFI_ONLY_KEY)


    override fun getSettings(): Flow<Settings> = context.dataStore.data.map { preferences ->
        val language = preferences[languageKey]?.let { Language.valueOf(it) }
            ?: Settings.DEFAULT_LANGUAGE
        val intervalMinutes = preferences[intervalKey]?.toInterval()
            ?: Settings.DEFAULT_INTERVAL
        val notificationsEnabled = preferences[notificationsEnabledKey]
            ?: Settings.DEFAULT_NOTIFICATIONS_ENABLED
        val wifiOnly = preferences[wifiOnlyKey]
            ?: Settings.DEFAULT_WIFI_ONLY

        Settings(
            language = language,
            interval = intervalMinutes,
            notificationsEnabled = notificationsEnabled,
            wifiOnly = wifiOnly
        )
    }

    override suspend fun updateLanguage(language: Language) {
        context.dataStore.edit { preferences ->
            preferences[languageKey] = language.name
        }
    }

    override suspend fun updateInterval(minutes: Int) {
        context.dataStore.edit { preferences ->
            preferences[intervalKey] = minutes
        }
    }

    override suspend fun updateNotificationsEnables(enabled: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[notificationsEnabledKey] = enabled
        }
    }

    override suspend fun updateWifiOnlyEnables(wifiOnly: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[wifiOnlyKey] = wifiOnly
        }
    }
}