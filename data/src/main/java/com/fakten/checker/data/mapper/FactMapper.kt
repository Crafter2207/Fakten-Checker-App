package com.fakten.checker.data.mapper

import com.fakten.checker.data.remote.dto.BackendResponse
import com.fakten.checker.data.remote.dto.FactDto
import com.fakten.checker.domain.model.Fact
import com.fakten.checker.domain.model.FactStatus
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun BackendResponse.toDomain(): Fact {
    val status = when {
        analysis.contains("wahr", ignoreCase = true) -> FactStatus.CONFIRMED
        analysis.contains("falsch", ignoreCase = true) -> FactStatus.INCORRECT
        else -> FactStatus.UNPROVEN
    }

    return Fact(
        statement = "Analyse für die angefragte URL",
        status = status,
        sources = emptyList(), // Das Backend liefert keine Quellen, daher leer
        checkDate = Date(),
        analysis = this.analysis
    )
}
