package com.zaelani.pendeteksigempadantsunami.ui.magnitude

import androidx.lifecycle.ViewModel
import com.zaelani.pendeteksigempadantsunami.data.DataGempaRepository

class MagnitudoViewModel(private val dataGempaRepository: DataGempaRepository): ViewModel() {
    fun getGempaMagnitudo() = dataGempaRepository.getGempaMagnitudo()
}