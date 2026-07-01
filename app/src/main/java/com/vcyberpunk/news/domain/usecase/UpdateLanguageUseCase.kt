package com.vcyberpunk.news.domain.usecase

import com.vcyberpunk.news.domain.entity.Language
import com.vcyberpunk.news.domain.repository.SettingsRepository
import javax.inject.Inject

class UpdateLanguageUseCase @Inject constructor(
    private val repository: SettingsRepository
) {

    suspend operator fun invoke(language: Language) = repository.updateLanguage(language)

}