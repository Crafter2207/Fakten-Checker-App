package com.fakten.checker.di

import com.fakten.checker.data.remote.MyBackendApi
import com.fakten.checker.data.repository.FactCheckRepositoryImpl
import com.fakten.checker.data.repository.LearningRepositoryImpl
import com.fakten.checker.domain.repository.FactCheckRepository
import com.fakten.checker.domain.repository.LearningRepository
import com.fakten.checker.domain.usecase.CheckFactUseCase
import com.fakten.checker.domain.usecase.GetLearningModulesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideMyBackendApi(): MyBackendApi {
        return Retrofit.Builder()
            .baseUrl("http://192.168.178.85:8000/") // Lokale PC-IP für physisches Gerät
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyBackendApi::class.java)
    }

    @Provides
    @Singleton
    fun provideFactCheckRepository(api: MyBackendApi): FactCheckRepository {
        return FactCheckRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideLearningRepository(): LearningRepository {
        return LearningRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideCheckFactUseCase(repository: FactCheckRepository): CheckFactUseCase {
        return CheckFactUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetLearningModulesUseCase(repository: LearningRepository): GetLearningModulesUseCase {
        return GetLearningModulesUseCase(repository)
    }
}

