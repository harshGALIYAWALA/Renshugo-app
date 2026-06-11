package com.shinkatech.renshugo.di.chooseLanguage

import com.shinkatech.renshugo.data.chooseLanguage.repositoryImpl.ChooseLanguageRepositoryImpl
import com.shinkatech.renshugo.domain.chooseLanguage.repository.ChooseLanguageRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ChooseLanguageModule {

    @Binds
    @Singleton
    abstract fun bindChooseLanguageRepository(
        repo: ChooseLanguageRepositoryImpl
    ): ChooseLanguageRepository

}