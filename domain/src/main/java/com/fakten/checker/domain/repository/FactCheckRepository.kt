package com.fakten.checker.domain.repository

import com.fakten.checker.domain.model.Fact

interface FactCheckRepository {
    suspend fun checkFact(url: String): Fact
}
