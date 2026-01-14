package com.fakten.checker.di

import com.fakten.checker.domain.repository.FactRepository
import com.fakten.checker.domain.repository.JournalistRepository
import com.fakten.checker.domain.repository.LearningRepository
import com.fakten.checker.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideCheckFactUseCase(repository: FactRepository): CheckFactUseCase {
        return CheckFactUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetProArgumentsUseCase(repository: FactRepository): GetProArgumentsUseCase {
        return GetProArgumentsUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetContraArgumentsUseCase(repository: FactRepository): GetContraArgumentsUseCase {
        return GetContraArgumentsUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideSubmitClaimUseCase(repository: FactRepository): SubmitClaimUseCase {
        return SubmitClaimUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetClaimStatusUseCase(repository: FactRepository): GetClaimStatusUseCase {
        return GetClaimStatusUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetLearningModulesUseCase(repository: LearningRepository): GetLearningModulesUseCase {
        return GetLearningModulesUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetLearningModuleProgressUseCase(repository: LearningRepository): GetLearningModuleProgressUseCase {
        return GetLearningModuleProgressUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideUpdateLearningModuleProgressUseCase(repository: LearningRepository): UpdateLearningModuleProgressUseCase {
        return UpdateLearningModuleProgressUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetArticlesUseCase(repository: JournalistRepository): GetArticlesUseCase {
        return GetArticlesUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideAskQuestionUseCase(repository: JournalistRepository): AskQuestionUseCase {
        return AskQuestionUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetAnsweredQuestionsUseCase(repository: JournalistRepository): GetAnsweredQuestionsUseCase {
        return GetAnsweredQuestionsUseCase(repository)
    }
}
