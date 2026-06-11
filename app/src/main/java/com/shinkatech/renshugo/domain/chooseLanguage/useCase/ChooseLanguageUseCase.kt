package com.shinkatech.renshugo.domain.chooseLanguage.useCase


import com.shinkatech.renshugo.domain.chooseLanguage.model.ChooseLanguageModel
import com.shinkatech.renshugo.domain.chooseLanguage.repository.ChooseLanguageRepository
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow

class ChooseLanguageUseCase @Inject constructor(
    private val repository: ChooseLanguageRepository
) {

    suspend fun getAllLanguages(): Flow<List<ChooseLanguageModel>>{
        return repository.getAllLanguages()
    }

    fun getSelectLanguage(languageCode: String){
        return repository.getSelectLanguage(languageCode)
    }

    suspend fun currentSelectedLanguage(): Flow<String?>{
        return repository.currentSelectLanguage()
    }

}