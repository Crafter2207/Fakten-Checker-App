package com.fakten.checker.data.repository

import com.fakten.checker.data.remote.MyBackendApi
import com.fakten.checker.domain.model.Fact
import com.fakten.checker.domain.model.FactStatus
import com.fakten.checker.domain.repository.FactCheckRepository
import java.util.Date

class FactCheckRepositoryImpl(private val api: MyBackendApi) : FactCheckRepository {

    override suspend fun checkFact(url: String): Fact {
        val response = api.checkFactWithAi(url)
        // Basic mapping, can be improved
        val status = if (response.analysis.contains("wahr", ignoreCase = true)) {
            FactStatus.PROVEN_TRUE
        } else if (response.analysis.contains("falsch", ignoreCase = true)) {
            FactStatus.PROVEN_FALSE
        } else {
            FactStatus.UNPROVEN
        }

        return Fact(
            statement = url,
            status = status,
            sources = listOf(url),
            checkDate = Date(),
            analysis = response.analysis
        )
    }
}
