package com.fakten.checker.data.local

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun fromString(value: String): List<String> {
        return value.split(",").map { it.trim() }
    }

    @TypeConverter
    fun fromList(list: List<String>): String {
        return list.joinToString(",")
    }

    @TypeConverter
    fun fromFactStatus(status: com.fakten.checker.domain.model.FactStatus): String {
        return status.name
    }

    @TypeConverter
    fun toFactStatus(status: String): com.fakten.checker.domain.model.FactStatus {
        return com.fakten.checker.domain.model.FactStatus.valueOf(status)
    }
}
