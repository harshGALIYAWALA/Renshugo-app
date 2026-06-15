package com.shinkatech.renshugo.data.jlptLevel.dataSource

import com.shinkatech.renshugo.domain.jlptLevel.model.JpLevelModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class JpLevelDataSource @Inject constructor() {

    val jpLevelList = listOf(
        JpLevelModel("N5", "Beginner", "Basic greetings, hiragana, katakana, simple sentences", "689", "60"),
        JpLevelModel("N4", "Elementary", "Daily conversations, basic grammar and kanji", "1500", "120"),
        JpLevelModel("N3", "Intermediate", "Understand everyday Japanese and simple news", "3750", "370"),
        JpLevelModel("N2", "Upper Intermediate", "Read newspapers, business Japanese, advanced grammar", "6000", "1000"),
        JpLevelModel("N1", "Advanced", "Native-level comprehension of complex Japanese", "10000+", "2000+")
    )

    private val _currentLevel = MutableStateFlow<String?>(null)
    val currentLevel = _currentLevel.asStateFlow()

    fun getSelectLevel(level: String){
        _currentLevel.value = level
    }
}