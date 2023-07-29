package com.otamurod.cleanarchitecture

import android.app.Application
import com.otamurod.cleanarchitecture.di.components.ApplicationComponent
import com.otamurod.cleanarchitecture.di.components.DaggerApplicationComponent

class App : Application() {
    companion object {
        lateinit var applicationComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent
            .factory()
            .create(this)

        applicationComponent.inject(this)
    }
}