package com.harsh.ddlj.main.Dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun DasboardPage(dasboardViewModel: DasboardViewModel = hiltViewModel()) {
    val user = dasboardViewModel.getUser()
    dasboardViewModel.myName = "Hitika"
    Column {
        Text(text = "Hello from main")
        Text(text = " NAME: ${user.name}")
        Text(text = "AGE: ${user.age}")

    }

}
