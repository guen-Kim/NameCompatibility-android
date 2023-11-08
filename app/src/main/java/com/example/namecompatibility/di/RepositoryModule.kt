package com.example.namecompatibility.di

import com.example.data.repository.MainRepositoryImpl
import com.example.data.repository.remote.datasource.MainDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {


    @Provides
    @Singleton
    fun provideMainRepository(
        mainDataSource: MainDataSource
    ) : MainRepositoryImpl{
        return MainRepositoryImpl(
            mainDataSource
        )
    }

}