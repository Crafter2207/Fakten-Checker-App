package com.fakten.checker.data.mapper

import com.fakten.checker.data.remote.dto.FactDto
import com.fakten.checker.domain.model.Fact
import java.text.SimpleDateFormat
import java.util.Locale

fun FactDto.toDomain(): Fact {
    val date = try {
        // Versuch, das Datum zu parsen. Fallback auf aktuelles Datum.
        SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.GERMANY).parse(checkDate)
    } catch (e: Exception) {
        java.util.Date()
    }
    
    return Fact(
        statement = this.statement,
        status = this.status,
        sources = this.sources,
        checkDate = date ?: java.util.Date()
    )
}
