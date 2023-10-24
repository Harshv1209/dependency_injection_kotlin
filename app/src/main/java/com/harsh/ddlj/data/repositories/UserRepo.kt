package com.harsh.ddlj.data.repositories

import com.harsh.ddlj.data.module.User

interface UserRepo {
    fun getUser(name: String, age: Int): User
}