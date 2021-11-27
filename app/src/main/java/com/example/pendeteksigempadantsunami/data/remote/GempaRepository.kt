package com.example.pendeteksigempadantsunami.data.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import com.example.pendeteksigempadantsunami.data.local.DirasakanEntity
import com.example.pendeteksigempadantsunami.data.local.MagnitudoEntity
import com.example.pendeteksigempadantsunami.data.remote.response.GempaItemDirasakan
import com.example.pendeteksigempadantsunami.data.remote.response.GempaItemMagnitudo

import com.example.submissionarchitecturecomponent.utils.AppExecutors


class GempaRepository constructor(
    private val remoteDataSource: RemoteDataSource,
    private val appExecutors: AppExecutors
) : GempaDataSource {



    companion object {
        @Volatile
        private var instance: GempaRepository? = null

        fun getInstance(
            remoteData: RemoteDataSource,

            appExecutors: AppExecutors
        ): GempaRepository =
            instance ?: synchronized(this) {
                GempaRepository(remoteData,  appExecutors).apply {
                    instance = this
                }
            }
    }

   override fun getDirasakan(): LiveData<List<DirasakanEntity>> {
        val gempaResult = MutableLiveData<List<DirasakanEntity>>()

        remoteDataSource.getDirasakan(object : RemoteDataSource.LoadDirasakanCallback {
            override fun onAllDirasakanReceived(dirasakanGempa: List<GempaItemDirasakan>?) {
                val gempaList = ArrayList<DirasakanEntity>()
                if (dirasakanGempa != null) {
                    for (response in dirasakanGempa) {
                        with(response) {
                            val gempa = DirasakanEntity(
                                magnitude,
                                kedalaman,
                                dateTime,
                                wilayah,
                                dirasakan


                                )
                            gempaList.add(gempa)
                        }
                    }
                    gempaResult.postValue(gempaList)
                }
            }


        })
        return gempaResult
    }


    override fun getMagnitudo(): LiveData<List<MagnitudoEntity>> {
        val gempaResult = MutableLiveData<List<MagnitudoEntity>>()

        remoteDataSource.getMagnitudo(object : RemoteDataSource.LoadMagnitudoCallback {
            override fun onAllMagnitudoReceived(magnitudoGempa: List<GempaItemMagnitudo>?) {
                val gempaList = ArrayList<MagnitudoEntity>()
                if (magnitudoGempa != null) {
                    for (response in magnitudoGempa) {
                        with(response) {
                            val gempa = MagnitudoEntity(
                                magnitude,
                                kedalaman,
                                dateTime,
                                wilayah,
                                potensi

                            )
                            gempaList.add(gempa)
                        }
                    }
                    gempaResult.postValue(gempaList)
                }
            }


        })
        return gempaResult
    }





}