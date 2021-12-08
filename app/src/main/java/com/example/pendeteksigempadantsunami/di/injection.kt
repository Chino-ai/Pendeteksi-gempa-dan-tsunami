package com.example.pendeteksigempadantsunami.di

import android.content.Context
import com.example.pendeteksigempadantsunami.data.remote.GempaRepository
import com.example.pendeteksigempadantsunami.data.remote.RemoteDataSource
import com.example.pendeteksigempadantsunami.utils.AppExecutors



object Injection {
    fun provideRepository(context: Context): GempaRepository {

        val remoteDataSource = RemoteDataSource.getInstance()

        val appExecutors = AppExecutors()
        return GempaRepository.getInstance(remoteDataSource, appExecutors)
    }
}