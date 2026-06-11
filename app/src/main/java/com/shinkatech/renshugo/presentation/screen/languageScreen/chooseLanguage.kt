package com.shinkatech.renshugo.presentation.screen.languageScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.shinkatech.renshugo.presentation.navigation.Screen
import com.shinkatech.renshugo.presentation.screen.languageScreen.components.CustomLanguageSelectedCardView

@Composable
fun ChooseLanguageScreen(
    navController: NavController,
) {
    val colors = MaterialTheme.colorScheme

    val viewModel: ChooseLanguageViewModel = hiltViewModel()
    val languageList by viewModel.languageList.collectAsStateWithLifecycle()
    val selectedLanguage by viewModel.currentSelectedLanguage.collectAsStateWithLifecycle()

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
                text = "Pick the language for the app interface. You can change this anytime in Settings.",
                modifier = Modifier.fillMaxWidth(),
                color = colors.onBackground.copy(alpha = 0.7f),
                fontSize = 14.sp,
                lineHeight = 18.sp
            )

            Spacer(modifier = Modifier.height(16.dp))
        }

        items(languageList, key = { it.code }) { item ->
            CustomLanguageSelectedCardView(
                language = item.nativeName,
                translatedLanguage = item.englishName,
                isSelected = { item.code == selectedLanguage },
                onClick = { viewModel.selectedLanguage(item.code) }
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    // navigation lvl screen
                },
                enabled = selectedLanguage != null,
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colors.primary,
                    contentColor = colors.onPrimary
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 2.dp,
                    pressedElevation = 6.dp
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
