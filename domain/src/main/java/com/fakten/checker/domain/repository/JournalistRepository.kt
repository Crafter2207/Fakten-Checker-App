package com.fakten.checker.domain.repository

import com.fakten.checker.domain.model.Article
import com.fakten.checker.domain.model.Question

/**
 * Interface for the repository that handles journalist-provided content.
 */
interface JournalistRepository {

    /**
     * Retrieves all background articles.
     *
     * @return A list of [Article]s.
     */
    suspend fun getArticles(): List<Article>

    /**
     * Asks a question to be answered by a journalist.
     *
     * @param question The question to be asked.
     */
    suspend fun askQuestion(question: String)

    /**
     * Retrieves all publicly answered questions.
     *
     * @return A list of answered [Question]s.
     */
    suspend fun getAnsweredQuestions(): List<Question>
}
