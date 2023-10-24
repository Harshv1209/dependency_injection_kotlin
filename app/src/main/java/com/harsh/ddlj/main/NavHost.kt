package com.harsh.ddlj.main

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.harsh.ddlj.Routes
import com.harsh.ddlj.main.Dashboard.DasboardPage


fun NavGraphBuilder.MainNavigation(navController: NavHostController) {
    navigation(
        route = Routes.DASHBOARD_PAGE, startDestination = Routes.DASHBOARD_PAGE
    ) {
        composable(Routes.DASHBOARD_PAGE) {
            DasboardPage()
        }
        composable(Routes.PROFILE_PAGE) {
            ProfilePage()
        }
    }
}

