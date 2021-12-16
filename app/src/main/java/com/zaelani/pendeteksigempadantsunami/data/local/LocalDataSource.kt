package com.zaelani.pendeteksigempadantsunami.data.local

import androidx.paging.DataSource
import com.zaelani.pendeteksigempadantsunami.data.local.entity.DirasakanEntity
import com.zaelani.pendeteksigempadantsunami.data.local.entity.MagnitudoEntity
import com.zaelani.pendeteksigempadantsunami.data.local.room.GempaDao

class LocalDataSource(private val mGempaDao: GempaDao) {
    fun getGempaDirasakan() : DataSource.Factory<Int, DirasakanEntity> = mGempaDao.getGempaDirasakan()

    fun getGempaMagnitudo() : DataSource.Factory<Int, MagnitudoEntity> = mGempaDao.getGempaMagnitudo()

    fun insertGempaDirasakan(dirasakanEntity: DirasakanEntity){
        mGempaDao.insertGempaDirasakan(dirasakanEntity)
    }

    fun insertGempaMagnitudo(magnitudoEntity: MagnitudoEntity){
        mGempaDao.insertGempaMagnitude(magnitudoEntity)
    }

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(gempaDao: GempaDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(gempaDao)
    }
}