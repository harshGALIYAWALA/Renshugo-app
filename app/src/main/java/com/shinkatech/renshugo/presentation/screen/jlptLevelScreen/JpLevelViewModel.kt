package com.shinkatech.renshugo.presentation.screen.jlptLevelScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shinkatech.renshugo.domain.jlptLevel.model.JpLevelModel
import com.shinkatech.renshugo.domain.jlptLevel.useCase.JpLevelUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class JpLevelViewModel @Inject constructor(
    private val jpUseCase: JpLevelUseCase
): ViewModel() {

    private val _jpLevelList = MutableStateFlow<List<JpLevelModel>>(emptyList())
    val jpLevelList = _jpLevelList.asStateFlow()

    private val _currentLevel = MutableStateFlow<String?>(null)
    val currentLevel = _currentLevel.asStateFlow()

    init {
        observeLevelList()
        observeCurrentLevel()
    }

    fun observeLevelList(){
        viewModelScope.launch {
            jpUseCase.getAllJpLevels().collect { list->
                _jpLevelList.value = list
            }
        }
    }

    fun observeCurrentLevel(){
        viewModelScope.launch {
            jpUseCase.getCurrentLevel().collect { level->
                _currentLevel.value = level
            }
        }
    }

    fun getSelectedLevel(level: String){
        viewModelScope.launch {
            jpUseCase.getSelectedLevel(level)
        }
    }

}