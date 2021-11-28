package com.example.pendeteksigempadantsunami.ui.gempa.dirasakan

import androidx.lifecycle.ViewModel
import com.example.pendeteksigempadantsunami.data.remote.GempaRepository

class DirasakanViewModel(private val gempaRepository: GempaRepository): ViewModel() {

    fun getDirasakan() = gempaRepository.getDirasakan()
}