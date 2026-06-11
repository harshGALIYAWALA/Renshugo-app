package com.shinkatech.renshugo.presentation.screen.languageScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shinkatech.renshugo.domain.chooseLanguage.model.ChooseLanguageModel
import com.shinkatech.renshugo.domain.chooseLanguage.useCase.ChooseLanguageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChooseLanguageViewModel @Inject constructor(
    private val chooseLanguageUseCase: ChooseLanguageUseCase
) : ViewModel() {

    private val _languageList = MutableStateFlow<List<ChooseLanguageModel>>(emptyList())
    val languageList = _languageList.asStateFlow()

    private val _currentSelectedLanguage = MutableStateFlow<String?>(null)
    val currentSelectedLanguage = _currentSelectedLanguage.asStateFlow()


    init {
        loadLanguageList()
        observeSelectedLanguage()
    }

    fun loadLanguageList(){
        viewModelScope.launch {
            chooseLanguageUseCase.getAllLanguages().collect {list ->
                _languageList.value = list
            }
        }
    }

    fun observeSelectedLanguage(){
        viewModelScope.launch {
            chooseLanguageUseCase.currentSelectedLanguage().collect { code->
                _currentSelectedLanguage.value = code
            }
        }
    }

    fun selectedLanguage(languageCode: String){
        viewModelScope.launch {
            chooseLanguageUseCase.getSelectLanguage(languageCode)
        }
    }

}