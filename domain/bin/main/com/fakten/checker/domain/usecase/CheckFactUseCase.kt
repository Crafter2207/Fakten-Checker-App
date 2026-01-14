package com.fakten.checker.domain.usecase

import com.fakten.checker.domain.model.Fact
import com.fakten.checker.domain.repository.FactRepository

class CheckFactUseCase(private val factRepository: FactRepository) {

    suspend fun execute(text: String): Fact {
        return factRepository.checkFact(text)
    }

    suspend fun execute(url: String): Fact {
        return factRepository.checkFact(url)
    }
}
