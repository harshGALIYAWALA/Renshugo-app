package com.shinkatech.renshugo.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.shinkatech.renshugo.presentation.screen.SignUpScreen.SignUpScreen
import com.shinkatech.renshugo.presentation.screen.loginScreen.LoginScreen
import com.shinkatech.renshugo.presentation.screen.splashScreen.SplashScreen

sealed class Screen(val route: String){
   object Splash : Screen("splash")
    object Login : Screen("login")
    object SignUp : Screen("signUp")
}

@Composable
fun AppNavigation() {

    val mainNavController = rememberNavController()

    NavHost(mainNavController, startDestination = Screen.Splash.route) {

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
    }
}