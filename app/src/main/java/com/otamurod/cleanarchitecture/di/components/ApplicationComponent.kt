package com.otamurod.cleanarchitecture.di.components

import com.otamurod.cleanarchitecture.App
import com.otamurod.cleanarchitecture.di.module.ApplicationModule
import com.otamurod.cleanarchitecture.di.module.DataModule
import com.otamurod.cleanarchitecture.di.module.ViewModelModule
import com.otamurod.cleanarchitecture.presentation.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, DataModule::class, ViewModelModule::class])
interface ApplicationComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: App): ApplicationComponent
    }

    fun inject(app: App)
    fun inject(mainActivity: MainActivity)
}