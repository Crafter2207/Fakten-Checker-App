package com.fakten.checker.data.repository

import com.fakten.checker.domain.model.Article
import com.fakten.checker.domain.model.Question
import com.fakten.checker.domain.repository.JournalistRepository

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class JournalistRepositoryImpl @Inject constructor() : JournalistRepository {

    // TODO: Inject remote and local data sources

    override suspend fun getArticles(): List<Article> {
        return emptyList()
    }

    override suspend fun askQuestion(question: String) {
        // Placeholder
    }

    override suspend fun getAnsweredQuestions(): List<Question> {
        return emptyList()
    }
}
