package com.fakten.checker.domain.model

/**
 * Represents a question asked by a user and answered by a journalist.
 *
 * @property questionText The text of the question.
 * @property answerText The text of the answer.
 * @property journalistName The name of the journalist who answered the question.
 */
data class Question(
    val questionText: String,
    val answerText: String,
    val journalistName: String
)
