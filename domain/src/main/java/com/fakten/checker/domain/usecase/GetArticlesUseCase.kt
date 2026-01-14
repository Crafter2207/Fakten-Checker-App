package com.fakten.checker.domain.usecase

import com.fakten.checker.domain.model.Article
import com.fakten.checker.domain.repository.JournalistRepository

class GetArticlesUseCase(private val journalistRepository: JournalistRepository) {

    suspend fun execute(): List<Article> {
        return journalistRepository.getArticles()
    }
}
