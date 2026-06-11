package com.shinkatech.renshugo.data.chooseLanguage.repositoryImpl

import com.shinkatech.renshugo.data.chooseLanguage.dataSource.LanguageLocalDataSource
import com.shinkatech.renshugo.domain.chooseLanguage.model.ChooseLanguageModel
import com.shinkatech.renshugo.domain.chooseLanguage.repository.ChooseLanguageRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

import javax.inject.Inject

class ChooseLanguageRepositoryImpl @Inject constructor(
    private val languageLocalDataSource: LanguageLocalDataSource
): ChooseLanguageRepository {
    override suspend fun getAllLanguages(): Flow<List<ChooseLanguageModel>> {
        return flowOf(languageLocalDataSource.chooseLanguageList)
    }

    override fun getSelectLanguage(languageCode: String) {
        return languageLocalDataSource.getSelectLanguage(languageCode)
    }

    override suspend fun currentSelectLanguage(): Flow<String?> {
        return languageLocalDataSource.selectLanguage
    }

}