package com.example.examprojectapp.module

import android.app.Application
import android.content.Context
import com.example.data.TestQuizRepositoryMock
import com.example.domain.repository.TestQuizRepository
import com.example.domain.usecase.TestQuizUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun provideRepository(context: Context):TestQuizRepository{
        return TestQuizRepositoryMock(context)
    }

    @Provides
    @Singleton
    fun provideUseCase(repository: TestQuizRepository):TestQuizUseCase{
        return TestQuizUseCase(repository)
    }
}