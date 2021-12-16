package com.zaelani.pendeteksigempadantsunami.data

import androidx.lifecycle.LiveData
import com.zaelani.pendeteksigempadantsunami.data.local.entity.DirasakanEntity
import com.zaelani.pendeteksigempadantsunami.data.local.entity.MagnitudoEntity
import com.zaelani.pendeteksigempadantsunami.data.remote.response.terkini.TerkiniResponse

interface GempaDataSource {
    fun getGempaTerkini(): LiveData<TerkiniResponse>
    fun getGempaDirasakan(): LiveData<List<DirasakanEntity>>
    fun getGempaMagnitudo(): LiveData<List<MagnitudoEntity>>
}