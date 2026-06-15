package com.shinkatech.renshugo.domain.jlptLevel.repository

import com.shinkatech.renshugo.domain.jlptLevel.model.JpLevelModel
import kotlinx.coroutines.flow.Flow


interface JpLevelRepository {
    suspend fun getJpLevelList(): Flow<List<JpLevelModel>>
    fun getJpLevel(jpLevel: String)
    suspend fun getSelectJpLevel(): Flow<String?>
}