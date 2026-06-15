package com.shinkatech.renshugo.presentation.screen.jlptLevelScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.shinkatech.renshugo.presentation.screen.jlptLevelScreen.components.CustomLevelSelectCardView

@Composable
fun JpLevelScreen(navController: NavController) {
    val colors = MaterialTheme.colorScheme

    val viewModel: JpLevelViewModel = hiltViewModel()
    val levelList by viewModel.jpLevelList.collectAsStateWithLifecycle()
    val currentLevel by viewModel.currentLevel.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .navigationBarsPadding()
            .fillMaxSize()
            .padding(18.dp)
    ) {

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "What's your level?",
            modifier = Modifier.fillMaxWidth(),
            color = colors.onBackground,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 1.sp
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Select your JLPT level to start your path.",
            modifier = Modifier.fillMaxWidth(),
            color = colors.onBackground.copy(alpha = 0.7f),
            fontSize = 14.sp,
            lineHeight = 18.sp
        )

        Spacer(modifier = Modifier.height(16.dp))


        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(levelList, key = { it.jpLevel }) { item ->
                CustomLevelSelectCardView(
                    jpLevel = item.jpLevel,
                    levelTitle = item.levelTitle,
                    description = item.description,
                    wordNum = item.wordNum,
                    grammarNum = item.grammarNum,
                    isSelected = item.jpLevel == currentLevel,
                    onClick = { viewModel.getSelectedLevel(item.jpLevel) }
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // navigation lvl screen
            },
            enabled = currentLevel != null,
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