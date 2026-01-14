package com.fakten.checker.domain.model

/**
 * Represents a background article written by a journalist.
 *
 * @property title The title of the article.
 * @property content The content of the article.
 * @property author The author of the article.
 */
data class Article(
    val title: String,
    val content: String,
    val author: String
)
