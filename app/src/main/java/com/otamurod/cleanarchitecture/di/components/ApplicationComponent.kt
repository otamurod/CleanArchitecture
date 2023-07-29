package com.otamurod.cleanarchitecture.di.components

import com.otamurod.cleanarchitecture.App
import com.otamurod.cleanarchitecture.MainActivity
import com.otamurod.cleanarchitecture.di.module.ApplicationModule
import com.otamurod.cleanarchitecture.di.module.DataModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, DataModule::class])
interface ApplicationComponent {
    @Component.Factory
    interface Factory{
        fun create(@BindsInstance app:App):ApplicationComponent
    }

    fun inject(app: App)
    fun inject(mainActivity: MainActivity)
}