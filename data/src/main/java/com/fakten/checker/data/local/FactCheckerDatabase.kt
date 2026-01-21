package com.fakten.checker.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.fakten.checker.data.local.dao.FactDao
import com.fakten.checker.data.local.entity.FactEntity

@Database(
    entities = [FactEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class FactCheckerDatabase : RoomDatabase() {

    abstract fun factDao(): FactDao

    companion object {
        const val DATABASE_NAME = "fact_checker_db"

        @Volatile
        private var INSTANCE: FactCheckerDatabase? = null

        fun getInstance(context: Context): FactCheckerDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FactCheckerDatabase::class.java,
                    DATABASE_NAME
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}

