package com.shinkatech.renshugo.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.shinkatech.renshugo.presentation.screen.jlptLevelScreen.JpLevelScreen
import com.shinkatech.renshugo.presentation.screen.languageScreen.ChooseLanguageScreen
import com.shinkatech.renshugo.presentation.screen.loginScreen.LoginScreen
import com.shinkatech.renshugo.presentation.screen.signUpScreen.SignUpScreen
import com.shinkatech.renshugo.presentation.screen.splashScreen.SplashScreen

sealed class Screen(val route: String){
   data object Splash : Screen("splash")
    data object Login : Screen("login")
    data object SignUp : Screen("signUp")
    data object Language : Screen("language")
    data object JpLevel : Screen("jpLevel")
}

@Composable
fun AppNavigation() {

    val mainNavController = rememberNavController()

    NavHost(mainNavController, startDestination = Screen.Language.route) {

        // splash screen
        composable(Screen.Splash.route) {
            SplashScreen(mainNavController)
        }

        // login screen
        composable(Screen.Login.route) {
            LoginScreen(mainNavController)
        }

        // SignUp screen
        composable(Screen.SignUp.route) {
            SignUpScreen(mainNavController)
        }

        // Language screen
        composable(Screen.Language.route) {
            ChooseLanguageScreen(mainNavController)
        }

        // jpLevel screen
        composable(Screen.JpLevel.route) {
            JpLevelScreen(mainNavController)
        }
    }
}