package com.shinkatech.renshugo.di.jlptLevel

import com.shinkatech.renshugo.data.jlptLevel.repositoryImpl.JpLevelRepositoryImpl
import com.shinkatech.renshugo.domain.jlptLevel.repository.JpLevelRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class JpLevelModule {

    @Binds
    @Singleton
    abstract fun bindJpLevelRepository(
        repo: JpLevelRepositoryImpl
    ): JpLevelRepository

}