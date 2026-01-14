package com.fakten.checker.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.fakten.checker.data.local.dao.FactDao
import com.fakten.checker.data.local.entity.FactEntity

@Database(
    entities = [FactEntity::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class FactCheckerDatabase : RoomDatabase() {

    abstract fun factDao(): FactDao

    companion object {
        const val DATABASE_NAME = "fact_checker_db"
    }
}
