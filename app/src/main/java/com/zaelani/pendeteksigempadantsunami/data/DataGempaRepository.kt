package com.zaelani.pendeteksigempadantsunami.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.zaelani.pendeteksigempadantsunami.data.local.entity.DirasakanEntity
import com.zaelani.pendeteksigempadantsunami.data.local.entity.MagnitudoEntity
import com.zaelani.pendeteksigempadantsunami.data.remote.RemoteDataSource
import com.zaelani.pendeteksigempadantsunami.data.remote.response.dirasakan.DirasakanResponse
import com.zaelani.pendeteksigempadantsunami.data.remote.response.magnitudo.MagnitudoResponse
import com.zaelani.pendeteksigempadantsunami.data.remote.response.terkini.TerkiniResponse

class DataGempaRepository private constructor(
    private val remoteDataSource: RemoteDataSource
) : GempaDataSource{
    override fun getGempaTerkini():LiveData<TerkiniResponse>  {
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
                                null,
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
                        }
                    }
                    gempaDirasakan.postValue(dirasakanList)
                }
            }
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
                                null,
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
                        }
                    }
                    gempaMagnitudo.postValue(magnitudoList)
                }
            }
        })
        return gempaMagnitudo
    }

    companion object {

        @Volatile
        private var instance: DataGempaRepository? = null
        fun getInstance(remoteData: RemoteDataSource): DataGempaRepository =
            instance ?: synchronized(this) {
                instance ?: DataGempaRepository(remoteData)
            }
    }
}