package com.fakten.checker.domain.usecase

import com.fakten.checker.domain.model.Fact
import com.fakten.checker.domain.repository.FactCheckRepository

class CheckFactUseCase(private val repository: FactCheckRepository) {
    // Erweitert um den 'provider' Parameter
    suspend fun execute(url: String, provider: String): Fact {
        return repository.checkFact(url, provider)
    }
}
