package com.fakten.checker.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fakten.checker.data.local.entity.FactEntity

@Dao
interface FactDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFact(fact: FactEntity)

    @Query("SELECT * FROM facts WHERE id = :id")
    suspend fun getFactById(id: String): FactEntity?

    @Query("DELETE FROM facts WHERE id = :id")
    suspend fun deleteFact(id: String)
}
