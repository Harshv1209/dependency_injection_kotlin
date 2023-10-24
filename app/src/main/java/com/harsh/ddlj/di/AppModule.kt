package com.harsh.ddlj.di

import com.harsh.ddlj.data.repositories.UserRepo
import com.harsh.ddlj.data.repositories.UserRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun ProvideUserRepo(): UserRepo {
        return UserRepoImpl()
    }
}