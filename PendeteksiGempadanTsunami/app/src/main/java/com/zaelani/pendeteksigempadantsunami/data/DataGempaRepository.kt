package com.zaelani.pendeteksigempadantsunami.data

import kotlinx.coroutines.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.zaelani.pendeteksigempadantsunami.data.local.LocalDataSource
import com.zaelani.pendeteksigempadantsunami.data.local.entity.DirasakanEntity
import com.zaelani.pendeteksigempadantsunami.data.local.entity.MagnitudoEntity
import com.zaelani.pendeteksigempadantsunami.data.remote.RemoteDataSource
import com.zaelani.pendeteksigempadantsunami.data.remote.response.dirasakan.DirasakanResponse
import com.zaelani.pendeteksigempadantsunami.data.remote.response.magnitudo.MagnitudoResponse
import com.zaelani.pendeteksigempadantsunami.data.remote.response.terkini.TerkiniResponse
import com.zaelani.pendeteksigempadantsunami.utils.AppExecutors

class DataGempaRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : GempaDataSource{

    override fun getGempaTerkini(): LiveData<TerkiniResponse> {
        val gempaTerkini = MutableLiveData<TerkiniResponse>()

        remoteDataSource.getGempaTerkini(object : RemoteDataSource.LoadGempaTerkini{
            override fun onLoadedGempaTerkini(terkini: TerkiniResponse) {
                val gempa = TerkiniResponse(
                    terkini.dirasakan,
                    terkini.wilayah,
                    terkini.shakemap,
                    terkini.kedalaman,
                    terkini.jam,
                    terkini.coordinates,
                    terkini.potensi,
                    terkini.tanggal,
                    terkini.bujur,
                    terkini.magnitude,
                    terkini.lintang,
                    terkini.dateTime
                )
                gempaTerkini.postValue(gempa)
            }
        })
        return gempaTerkini
    }

    override fun getGempaDirasakan(): LiveData<List<DirasakanEntity>> {
        val gempaDirasakan = MutableLiveData<List<DirasakanEntity>>()

        remoteDataSource.getGempaDirasakan(object : RemoteDataSource.LoadGempaDirasakan{
            override fun onLoadedGempaDirasakan(dirasakan: List<DirasakanResponse>?) {
                val dirasakanList = ArrayList<DirasakanEntity>()
                if (dirasakan != null){
                    for (response in dirasakan){
                        with(response){
                            val gempa = DirasakanEntity(
                                this.dirasakan,
                                wilayah,
                                kedalaman,
                                jam,
                                coordinates,
                                tanggal,
                                bujur,
                                magnitude,
                                lintang,
                                dateTime
                            )
                            dirasakanList.add(gempa)
                            insertGempaDirasakan(gempa)
                        }
                    }
                    gempaDirasakan.postValue(dirasakanList)
                }
            }
        })

        gempaDirasakan.postValue(runBlocking {
            GlobalScope.async { localDataSource.getGempaDirasakan() }.await()
        })

        return gempaDirasakan
    }

    override fun getGempaMagnitudo(): LiveData<List<MagnitudoEntity>> {
        val gempaMagnitudo = MutableLiveData<List<MagnitudoEntity>>()

        remoteDataSource.getGempamagnitudo(object : RemoteDataSource.LoadGempaMagnitudo{
            override fun onLoadedGempaMagnitudo(magnitudo: List<MagnitudoResponse>?) {
                val magnitudoList = ArrayList<MagnitudoEntity>()
                if (magnitudo != null){
                    for (response in magnitudo){
                        with(response){
                            val gempa = MagnitudoEntity(
                                wilayah,
                                kedalaman,
                                jam,
                                coordinates,
                                potensi,
                                tanggal,
                                bujur,
                                magnitude,
                                lintang,
                                dateTime
                            )
                            magnitudoList.add(gempa)
                            insertGempaMagnitudo(gempa)
                        }
                    }
                    gempaMagnitudo.postValue(magnitudoList)
                }
            }
        })

        gempaMagnitudo.postValue(runBlocking {
            GlobalScope.async{ localDataSource.getGempaMagnitudo() }.await()
        })

        return gempaMagnitudo
    }

    fun insertGempaMagnitudo(gempa : MagnitudoEntity){
        appExecutors.diskIO().execute{
            localDataSource.insertGempaMagnitudo(gempa)
        }
    }

    fun insertGempaDirasakan(gempa : DirasakanEntity){
        appExecutors.diskIO().execute {
            localDataSource.insertGempaDirasakan(gempa)
        }
    }

    companion object {
        @Volatile
        private var instance: DataGempaRepository? = null
        fun getInstance(remoteData: RemoteDataSource, localDataSource: LocalDataSource, appExecutors: AppExecutors): DataGempaRepository =
            instance ?: synchronized(this) {
                instance ?: DataGempaRepository(remoteData, localDataSource, appExecutors)
            }
    }
}