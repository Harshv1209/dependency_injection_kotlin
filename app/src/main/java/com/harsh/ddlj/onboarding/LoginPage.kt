package com.harsh.ddlj.onboarding

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.harsh.ddlj.Routes

@Composable
fun LoginPage(navController: NavController) {
    Column {
        Text(text = "Hello from LoginPage")
        Button(onClick = { navController.navigate(Routes.SIGNUP_PAGE) }) {
            Text(text = "goto main ")
        }
    }

}