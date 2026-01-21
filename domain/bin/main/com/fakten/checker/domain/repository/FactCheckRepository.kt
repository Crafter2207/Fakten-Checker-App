package com.fakten.checker.domain.repository

import com.fakten.checker.domain.model.Fact

interface FactCheckRepository {
    // Erweitert um den 'provider' Parameter
    suspend fun checkFact(url: String, provider: String): Fact
}
