package com.example.namecompatibility.di

import com.example.domain.repository.MainRepository
import com.example.domain.repository.SplashRepository
import com.example.domain.usecase.CheckAppVersionUseCase
import com.example.domain.usecase.CheckLoveCalculatorUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)

class UseCaseModule {

    @Provides
    @Singleton
    fun provideCheckloveCalculatorUseCase(repository: MainRepository) =
        CheckLoveCalculatorUseCase(repository)


    @Provides
    @Singleton
    fun provideCheckAppVersionUseCase(repository: SplashRepository) =
        CheckAppVersionUseCase(repository)

}