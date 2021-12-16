package com.zaelani.pendeteksigempadantsunami.ui.home

import androidx.lifecycle.ViewModel
import com.zaelani.pendeteksigempadantsunami.data.DataGempaRepository

class HomeViewModel(private val dataGempaRepository: DataGempaRepository): ViewModel() {
    fun getGempaTerkini() = dataGempaRepository.getGempaTerkini()
}