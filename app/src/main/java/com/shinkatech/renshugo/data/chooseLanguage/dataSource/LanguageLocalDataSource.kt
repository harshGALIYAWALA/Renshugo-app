package com.shinkatech.renshugo.data.chooseLanguage.dataSource

import com.shinkatech.renshugo.domain.chooseLanguage.model.ChooseLanguageModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class LanguageLocalDataSource @Inject constructor() {

    val chooseLanguageList = listOf(
        ChooseLanguageModel("en", "English", "English"),
        ChooseLanguageModel("hi", "हिन्दी", "Hindi"),
        ChooseLanguageModel("zh-Hans", "中文", "Chinese (Simplified)"),
        ChooseLanguageModel("ko", "한국어", "Korean"),
        ChooseLanguageModel("es", "Español", "Spanish"),

//        ChooseLanguageModel("ja", "日本語", "Japanese"),
//        ChooseLanguageModel("fr", "Français", "French"),
//        ChooseLanguageModel("de", "Deutsch", "German"),
//        ChooseLanguageModel("it", "Italiano", "Italian"),
//        ChooseLanguageModel("pt", "Português", "Portuguese"),
//
//        ChooseLanguageModel("ru", "Русский", "Russian"),
//        ChooseLanguageModel("ar", "العربية", "Arabic"),
//        ChooseLanguageModel("tr", "Türkçe", "Turkish"),
//        ChooseLanguageModel("nl", "Nederlands", "Dutch"),
//        ChooseLanguageModel("pl", "Polski", "Polish"),
//
//        ChooseLanguageModel("sv", "Svenska", "Swedish"),
//        ChooseLanguageModel("da", "Dansk", "Danish"),
//        ChooseLanguageModel("fi", "Suomi", "Finnish"),
//        ChooseLanguageModel("no", "Norsk", "Norwegian"),
//        ChooseLanguageModel("el", "Ελληνικά", "Greek"),
//
//        ChooseLanguageModel("th", "ไทย", "Thai"),
//        ChooseLanguageModel("vi", "Tiếng Việt", "Vietnamese"),
//        ChooseLanguageModel("id", "Bahasa Indonesia", "Indonesian"),
//        ChooseLanguageModel("ms", "Bahasa Melayu", "Malay"),
//        ChooseLanguageModel("he", "עברית", "Hebrew"),
//
//        ChooseLanguageModel("uk", "Українська", "Ukrainian"),
//        ChooseLanguageModel("cs", "Čeština", "Czech"),
//        ChooseLanguageModel("hu", "Magyar", "Hungarian"),
//        ChooseLanguageModel("ro", "Română", "Romanian"),
//        ChooseLanguageModel("bg", "Български", "Bulgarian")
    )
    private val _selectLanguage = MutableStateFlow<String?>(null)
    val selectLanguage = _selectLanguage.asStateFlow()

    fun getSelectLanguage(language: String){
        _selectLanguage.value = language
    }
}

//ChooseLanguageModel("en", "English", "English"),
//ChooseLanguageModel("hi", "हिन्दी", "Hindi"),
//ChooseLanguageModel("zh-Hans", "中文", "Chinese (Simplified)"),
//ChooseLanguageModel("ko", "한국어", "Korean"),
//ChooseLanguageModel("es", "Español", "Spanish"),