package com.harsh.ddlj.data.repositories

import com.harsh.ddlj.data.module.User

class UserRepoImpl : UserRepo {
    override fun getUser(name: String, age: Int): User {
        return User(name, age)
    }
}