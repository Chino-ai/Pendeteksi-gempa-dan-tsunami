package com.zaelani.pendeteksigempadantsunami.di

import android.content.Context
import com.zaelani.pendeteksigempadantsunami.data.DataGempaRepository
import com.zaelani.pendeteksigempadantsunami.data.remote.RemoteDataSource

object Injection {
    fun provideRepository(context: Context): DataGempaRepository{
        val remoteDataSource = RemoteDataSource.getInstance()
        return DataGempaRepository.getInstance(remoteDataSource)
    }
}