package com.fakten.checker.domain.usecase

import com.fakten.checker.domain.model.Argument
import com.fakten.checker.domain.repository.FactRepository

class GetContraArgumentsUseCase(private val factRepository: FactRepository) {

    suspend fun execute(factId: String): List<Argument> {
        return factRepository.getContraArguments(factId)
    }
}
