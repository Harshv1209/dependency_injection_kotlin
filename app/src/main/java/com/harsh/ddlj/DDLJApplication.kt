package com.harsh.ddlj

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DDLJApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}