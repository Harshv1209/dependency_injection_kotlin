package com.harsh.ddlj.main.Dashboard

import androidx.lifecycle.ViewModel
import com.harsh.ddlj.data.module.User
import com.harsh.ddlj.data.repositories.UserRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DasboardViewModel @Inject constructor(
    private val UserRepo: UserRepo
) : ViewModel() {
    var myName = "Harsh"
    fun getUser(): User {
        return UserRepo.getUser("Raj", 21)
    }
}