package com.example.pendeteksigempadantsunami.ui.gempa.magnitudo

import androidx.lifecycle.ViewModel
import com.example.pendeteksigempadantsunami.data.remote.GempaRepository

class MagnitudoViewModel(private val gempaRepository: GempaRepository) : ViewModel() {

    fun getMagnitudo() = gempaRepository.getMagnitudo()
}