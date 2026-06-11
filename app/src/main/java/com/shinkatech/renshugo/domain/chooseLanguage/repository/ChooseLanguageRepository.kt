package com.shinkatech.renshugo.domain.chooseLanguage.repository

import com.shinkatech.renshugo.domain.chooseLanguage.model.ChooseLanguageModel
import kotlinx.coroutines.flow.Flow

interface ChooseLanguageRepository {
    suspend fun getAllLanguages(): Flow<List<ChooseLanguageModel>>
    fun getSelectLanguage(languageCode: String)
    suspend fun currentSelectLanguage(): Flow<String?>
}