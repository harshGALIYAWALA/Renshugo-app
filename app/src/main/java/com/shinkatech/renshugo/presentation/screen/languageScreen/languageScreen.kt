package com.shinkatech.renshugo.presentation.screen.languageScreen

import android.widget.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.shinkatech.renshugo.R
import com.shinkatech.renshugo.presentation.screen.languageScreen.helper.CustomLanguageSelectedCardView
import com.shinkatech.renshugo.presentation.screen.languageScreen.helper.LanguageModel


@Composable
fun LanguageScreen(mainNavController: NavHostController) {

    val colors = MaterialTheme.colorScheme
    var selectIndex by remember { mutableIntStateOf(-1) }

    val languageList = remember {
        listOf(
            LanguageModel(
                language = "English", translatedLanguage = "English"
            ), LanguageModel(
                language = "中文", translatedLanguage = "Chinese"
            ), LanguageModel(
                language = "हिन्दी", translatedLanguage = "Hindi"
            ), LanguageModel(
                language = "Español", translatedLanguage = "Spanish"
            ), LanguageModel(
                language = "Français", translatedLanguage = "French"
            )
        )
    }

    LazyColumn(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize()
            .padding(18.dp)

    ) {

        item {
            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Choose your language",
                modifier = Modifier.fillMaxWidth(),
                color = colors.onBackground,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.sp
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Pick the language for the app interface. you can change this anytime in the settings.",
                modifier = Modifier.fillMaxWidth().padding(0.dp),
                color = colors.onBackground.copy(alpha = 0.7f),
                fontSize = 14.sp,
                lineHeight = 18.sp
            )

            Spacer(modifier = Modifier.height(16.dp))
        }

        itemsIndexed(languageList, key = { _, item -> item.language }) { index, item ->
            CustomLanguageSelectedCardView(
                language = item.language,
                translatedLanguage = item.translatedLanguage,
                isSelected = selectIndex == index,
                onClick = {
                    selectIndex = index
                })

            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                },
                enabled = selectIndex != -1,
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 2.dp, pressedElevation = 6.dp
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Continue",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }

        }

    }
}
