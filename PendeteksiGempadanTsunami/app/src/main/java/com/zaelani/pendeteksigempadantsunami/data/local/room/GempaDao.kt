package com.zaelani.pendeteksigempadantsunami.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.zaelani.pendeteksigempadantsunami.data.local.entity.DirasakanEntity
import com.zaelani.pendeteksigempadantsunami.data.local.entity.MagnitudoEntity

@Dao
interface GempaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGempaDirasakan(dirasakanEntity: DirasakanEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGempaMagnitude(magnitudoEntity: MagnitudoEntity)

    @Query("SELECT * FROM dirasakan_entities")
    fun getGempaDirasakan(): List<DirasakanEntity>

    @Query("SELECT * FROM magnitudo_entities")
    fun getGempaMagnitudo(): List<MagnitudoEntity>
}