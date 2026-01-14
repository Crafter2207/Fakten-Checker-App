package com.fakten.checker.di

import android.app.Application
import androidx.room.Room
import com.fakten.checker.data.local.FactCheckerDatabase
import com.fakten.checker.data.remote.FactCheckService
import com.fakten.checker.data.repository.FactRepositoryImpl
import com.fakten.checker.data.repository.JournalistRepositoryImpl
import com.fakten.checker.data.repository.LearningRepositoryImpl
import com.fakten.checker.domain.repository.FactRepository
import com.fakten.checker.domain.repository.JournalistRepository
import com.fakten.checker.domain.repository.LearningRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.example.com/") // Replace with actual API base URL
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideFactCheckService(retrofit: Retrofit): FactCheckService {
        return retrofit.create(FactCheckService::class.java)
    }

    @Provides
    @Singleton
    fun provideFactCheckerDatabase(app: Application): FactCheckerDatabase {
        return Room.databaseBuilder(
            app,
            FactCheckerDatabase::class.java,
            FactCheckerDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideFactRepository(service: FactCheckService, db: FactCheckerDatabase): FactRepository {
        return FactRepositoryImpl(service, db.factDao())
    }

    @Provides
    @Singleton
    fun provideLearningRepository(): LearningRepository {
        return LearningRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideJournalistRepository(): JournalistRepository {
        return JournalistRepositoryImpl()
    }
}
