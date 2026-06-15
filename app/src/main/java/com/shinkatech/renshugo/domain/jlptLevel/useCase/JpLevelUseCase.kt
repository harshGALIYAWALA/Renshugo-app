package com.shinkatech.renshugo.domain.jlptLevel.useCase

import com.shinkatech.renshugo.domain.jlptLevel.model.JpLevelModel
import com.shinkatech.renshugo.domain.jlptLevel.repository.JpLevelRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class JpLevelUseCase @Inject constructor(
    private val repository: JpLevelRepository
) {

    suspend fun getAllJpLevels(): Flow<List<JpLevelModel>> {
        return repository.getJpLevelList()
    }

    suspend fun getCurrentLevel(): Flow<String?> {
        return repository.getSelectJpLevel()
    }

    fun getSelectedLevel(level: String) {
        return repository.getJpLevel(level)
    }

}