package com.fakten.checker.domain.model

import java.util.Date

data class Fact(
    val statement: String,
    val status: FactStatus,
    val sources: List<String>,
    val checkDate: Date,
    val analysis: String? = null
)
