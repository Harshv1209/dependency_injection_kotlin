package com.harsh.ddlj

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.harsh.ddlj.main.Chats
import com.harsh.ddlj.main.Dashboard.DasboardPage
import com.harsh.ddlj.main.ProfilePage
import com.harsh.ddlj.main.Shorts

object Routes {

    const val DASHBOARD_PAGE = "dashboard"
    const val PROFILE_PAGE = "profile"
    const val SHORTS_PAGE = "shorts"
    const val CHATS_PAGE = "chats"

    const val ONBOARDING = "onboarding"
    const val LOGIN_PAGE = "$ONBOARDING/login"
    const val WELCOME_PAGE = "$ONBOARDING/welcome"
    const val SIGNUP_PAGE = "$ONBOARDING/signup"
}

data class BottomNavItem(val title: String, val route: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    var presses by remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Top app bar")
                }
            )
        },
        bottomBar = {
            var selectedItem by remember { mutableIntStateOf(0) }
            val items = listOf<BottomNavItem>(
                BottomNavItem(
                    title = "dashboard", route = Routes.DASHBOARD_PAGE
                ),
                BottomNavItem(
                    title = "profile", route = Routes.PROFILE_PAGE
                ),
                BottomNavItem(
                    title = "shorts", route = Routes.SHORTS_PAGE
                ),
                BottomNavItem(
                    title = "chats", route = Routes.CHATS_PAGE
                ),
            )

            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = {
                            Icon(
                                imageVector = Icons.Default.Favorite,
                                contentDescription = " "
                            )
                        },
                        label = { Text(item.title) },
                        selected = selectedItem == index,
                        onClick = {
                            selectedItem = index
                            navController.navigate(item.route)
                        }
                    )
                }
            }
        },

        ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            NavHost(navController = navController, startDestination = Routes.DASHBOARD_PAGE) {
//                MainNavigation(navController=navController)
//                onboardingNavigation(navController = navController)

                composable(Routes.DASHBOARD_PAGE) {
                    DasboardPage()
                }
                composable(Routes.PROFILE_PAGE) {
                    ProfilePage()
                }

                composable(Routes.SHORTS_PAGE) {
                    Shorts()
                }
                composable(Routes.CHATS_PAGE) {
                    Chats()
                }

            }
        }
    }

}


