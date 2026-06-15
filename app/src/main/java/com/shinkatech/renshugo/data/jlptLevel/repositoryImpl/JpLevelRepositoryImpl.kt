package com.shinkatech.renshugo.data.jlptLevel.repositoryImpl

import com.shinkatech.renshugo.data.jlptLevel.dataSource.JpLevelDataSource
import com.shinkatech.renshugo.domain.jlptLevel.model.JpLevelModel
import com.shinkatech.renshugo.domain.jlptLevel.repository.JpLevelRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class JpLevelRepositoryImpl @Inject constructor(
    private val localData: JpLevelDataSource
): JpLevelRepository {
    override suspend fun getJpLevelList(): Flow<List<JpLevelModel>> {
        return flowOf(localData.jpLevelList)
    }

    override fun getJpLevel(jpLevel: String) {
        return localData.getSelectLevel(jpLevel)
    }

    override suspend fun getSelectJpLevel(): Flow<String?> {
        return localData.currentLevel
    }
}