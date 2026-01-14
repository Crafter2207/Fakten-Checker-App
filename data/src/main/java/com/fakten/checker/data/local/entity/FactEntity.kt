package com.fakten.checker.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fakten.checker.domain.model.FactStatus

@Entity(tableName = "facts")
data class FactEntity(
    @PrimaryKey val id: String,
    val statement: String,
    val status: FactStatus,
    val sources: List<String>,
    val checkDate: Long
)
