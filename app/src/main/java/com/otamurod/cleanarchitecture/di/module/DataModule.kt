package com.otamurod.cleanarchitecture.di.module

import com.otamurod.data.network.ApiService
import com.otamurod.data.repository.UserRepositoryImpl
import com.otamurod.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [DataModule.BindModule::class])
class DataModule {
    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Module
    abstract class BindModule {
        @Binds
        abstract fun bindApiRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository
    }
}