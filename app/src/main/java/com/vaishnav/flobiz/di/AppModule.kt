package com.vaishnav.flobiz.di

import com.vaishnav.flobiz.data.network.ApiService
import com.vaishnav.flobiz.data.network.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideTargetApi(
        remoteDataSource: RemoteDataSource
    ): ApiService {
        return remoteDataSource.buildApi(ApiService::class.java)
    }
}