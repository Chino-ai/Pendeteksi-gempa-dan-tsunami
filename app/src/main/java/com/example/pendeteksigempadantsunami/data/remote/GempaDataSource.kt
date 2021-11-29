package com.example.pendeteksigempadantsunami.data.remote

import androidx.lifecycle.LiveData
import com.example.pendeteksigempadantsunami.data.local.DirasakanEntity
import com.example.pendeteksigempadantsunami.data.local.MagnitudoEntity

interface GempaDataSource {

    fun getDirasakan(): LiveData<List<DirasakanEntity>>

    fun getMagnitudo(): LiveData<List<MagnitudoEntity>>

}