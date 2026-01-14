package com.fakten.checker.data.repository

import com.fakten.checker.domain.model.Article
import com.fakten.checker.domain.model.Question
import com.fakten.checker.domain.repository.JournalistRepository

class JournalistRepositoryImpl : JournalistRepository {

    // TODO: Inject remote and local data sources

    override suspend fun getArticles(): List<Article> {
        // TODO: Implement API call to get articles
        TODO("Not yet implemented")
    }

    override suspend fun askQuestion(question: String) {
        // TODO: Implement API call to ask a question
        TODO("Not yet implemented")
    }

    override suspend fun getAnsweredQuestions(): List<Question> {
        // TODO: Implement API call to get answered questions
        TODO("Not yet implemented")
    }
}
