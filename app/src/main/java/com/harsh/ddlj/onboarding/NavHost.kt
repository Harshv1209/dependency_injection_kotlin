package com.harsh.ddlj.onboarding

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.harsh.ddlj.Routes

fun NavGraphBuilder.onboardingNavigation(navController: NavHostController) {
    navigation(route = Routes.ONBOARDING, startDestination = Routes.WELCOME_PAGE) {
        composable(Routes.WELCOME_PAGE) {
            WelcomePage(navController = navController)
        }
        composable(Routes.LOGIN_PAGE) {
            LoginPage(navController = navController)
        }
    }

}