package com.zaelani.pendeteksigempadantsunami.data.local.room

import androidx.paging.DataSource
import androidx.room.*
import com.zaelani.pendeteksigempadantsunami.data.local.entity.DirasakanEntity
import com.zaelani.pendeteksigempadantsunami.data.local.entity.MagnitudoEntity

@Dao
interface GempaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGempaDirasakan(dirasakanEntity: DirasakanEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGempaMagnitude(magnitudoEntity: MagnitudoEntity)

    @Query("SELECT * FROM dirasakan_entities")
    fun getGempaDirasakan(): DataSource.Factory<Int, DirasakanEntity>

    @Query("SELECT * FROM magnitudo_entities")
    fun getGempaMagnitudo(): DataSource.Factory<Int, MagnitudoEntity>
}