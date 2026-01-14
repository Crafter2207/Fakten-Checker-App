package com.fakten.checker.data.remote.dto

/**
 * Data Transfer Object for a question.
 */
data class QuestionDto(
    val questionText: String,
    val answerText: String,
    val journalistName: String
)
