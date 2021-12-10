package com.zaelani.pendeteksigempadantsunami.ui.dirasakan

import androidx.lifecycle.ViewModel
import com.zaelani.pendeteksigempadantsunami.data.DataGempaRepository

class DirasakanViewModel(private val dataGempaRepository: DataGempaRepository): ViewModel() {
    fun getGempaDirasakan() = dataGempaRepository.getGempaDirasakan()
}