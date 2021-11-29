package com.example.pendeteksigempadantsunami.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pendeteksigempadantsunami.data.remote.GempaRepository
import com.example.pendeteksigempadantsunami.di.Injection
import com.example.pendeteksigempadantsunami.ui.gempa.dirasakan.DirasakanViewModel
import com.example.pendeteksigempadantsunami.ui.gempa.magnitudo.MagnitudoViewModel
import com.example.pendeteksigempadantsunami.ui.gempa.terkini.TerkiniViewModel


class ViewModelFactory private constructor(private val mGempaRepository: GempaRepository) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(DirasakanViewModel::class.java) -> {
                return DirasakanViewModel(mGempaRepository) as T
            }
            modelClass.isAssignableFrom(MagnitudoViewModel::class.java) -> {
                return MagnitudoViewModel(mGempaRepository) as T
            }
            modelClass.isAssignableFrom(TerkiniViewModel::class.java) -> {
                return TerkiniViewModel(mGempaRepository) as T
            }

            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }

    }
}