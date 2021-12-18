package com.zaelani.pendeteksigempadantsunami.di

import android.content.Context
import com.zaelani.pendeteksigempadantsunami.data.DataGempaRepository
import com.zaelani.pendeteksigempadantsunami.data.local.LocalDataSource
import com.zaelani.pendeteksigempadantsunami.data.local.room.GempaDatabase
import com.zaelani.pendeteksigempadantsunami.data.remote.RemoteDataSource
import com.zaelani.pendeteksigempadantsunami.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): DataGempaRepository{
        val database = GempaDatabase.getInstance(context)
        val remoteDataSource = RemoteDataSource.getInstance()
        val localDataSource = LocalDataSource.getInstance(database.gempaDao())
        val appExecutors = AppExecutors()
        return DataGempaRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}