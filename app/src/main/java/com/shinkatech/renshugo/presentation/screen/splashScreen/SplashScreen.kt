package com.shinkatech.renshugo.presentation.screen.splashScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.shinkatech.renshugo.R
import com.shinkatech.renshugo.presentation.navigation.Screen
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds


@Composable
fun SplashScreen(navController: NavController) {

    val colors = MaterialTheme.colorScheme

    LaunchedEffect(Unit) {
        delay(2000.milliseconds)
        navController.navigate(Screen.Login.route) {
            popUpTo(0) 
        }
    }
    
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Spacer(modifier = Modifier.weight(1f))

        Image(
            painter = painterResource(R.drawable.ic_app_logo),
            contentDescription = stringResource(R.string.app_logo_txt),
        )

        Text(
            text = buildAnnotatedString {
                withStyle(SpanStyle(color = colors.onBackground)) { append(stringResource(R.string.ren_txt)) }
                withStyle(SpanStyle(color = colors.primary)) { append(stringResource(R.string.shu_txt)) }
                withStyle(SpanStyle(color = colors.onBackground)) { append(stringResource(R.string.go_txt)) }
            },
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Black,
            fontSize = 48.sp,
            letterSpacing = 3.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = stringResource(R.string.practice_learn_grow_txt),
            fontSize = 16.sp,
            color = colors.onBackground.copy(alpha = 0.7f),
            letterSpacing = 1.sp
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = stringResource(R.string.app_version_txt),
            fontSize = 16.sp,
            color = colors.onBackground.copy(alpha = 0.7f), letterSpacing = 1.sp
        )
        Spacer(modifier = Modifier.height(24.dp))
    }

}