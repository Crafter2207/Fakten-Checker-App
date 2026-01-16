package com.fakten.checker.domain.usecase

import com.fakten.checker.domain.model.Fact
import com.fakten.checker.domain.repository.FactRepository

class CheckFactUseCase(private val factRepository: FactRepository) {

    suspend fun executeFromText(text: String): Fact {
        return factRepository.checkFactFromText(text)
    }

    suspend fun executeFromUrl(url: String): Fact {
        return factRepository.checkFactFromUrl(url)
    }
}
