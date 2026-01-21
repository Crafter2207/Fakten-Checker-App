package com.fakten.checker.di

import android.content.Context
import com.fakten.checker.data.local.FactCheckerDatabase
import com.fakten.checker.data.remote.MyBackendApi
import com.fakten.checker.data.repository.FactCheckRepositoryImpl
import com.fakten.checker.data.repository.LearningRepositoryImpl
import com.fakten.checker.domain.repository.FactCheckRepository
import com.fakten.checker.domain.repository.LearningRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

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
    fun provideDatabase(@ApplicationContext context: Context): FactCheckerDatabase {
        // Room database - implement when needed
        return FactCheckerDatabase.getInstance(context)
    }
}

