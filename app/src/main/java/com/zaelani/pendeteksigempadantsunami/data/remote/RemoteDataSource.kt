package com.zaelani.pendeteksigempadantsunami.data.remote

import android.util.Log
import com.zaelani.pendeteksigempadantsunami.data.remote.response.dirasakan.DirasakanResponse
import com.zaelani.pendeteksigempadantsunami.data.remote.response.dirasakan.InfoGempaDirasakan
import com.zaelani.pendeteksigempadantsunami.data.remote.response.magnitudo.InfoGempaMagnitudo
import com.zaelani.pendeteksigempadantsunami.data.remote.response.magnitudo.MagnitudoResponse
import com.zaelani.pendeteksigempadantsunami.data.remote.response.terkini.InfoGempaTerkini
import com.zaelani.pendeteksigempadantsunami.data.remote.response.terkini.TerkiniResponse
import com.zaelani.pendeteksigempadantsunami.network.ApiConfig
import com.zaelani.pendeteksigempadantsunami.ui.home.HomeFragment.Companion.buffer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {

    fun getGempaTerkini(callback: LoadGempaTerkini){
        val client = ApiConfig.getApiService().getTerkini()
        client.enqueue(object : Callback<InfoGempaTerkini>{
            override fun onResponse(
                call: Call<InfoGempaTerkini>,
                response: Response<InfoGempaTerkini>
            ) {
                response.body()?.infogempa?.gempa?.let { callback.onLoadedGempaTerkini(it) }
                buffer.content = response.body()?.infogempa?.gempa?.wilayah
            }

            override fun onFailure(call: Call<InfoGempaTerkini>, t: Throwable) {
                Log.e("RemoteDataSource", "getGempaTerkini onFailure : ${t.message}")
            }

        })
    }

    fun getGempaDirasakan(callback: LoadGempaDirasakan){
        val client = ApiConfig.getApiService().getDirasakan()
        client.enqueue(object : Callback<InfoGempaDirasakan>{
            override fun onResponse(
                call: Call<InfoGempaDirasakan>,
                response: Response<InfoGempaDirasakan>
            ) {
                callback.onLoadedGempaDirasakan(response.body()?.infogempa?.gempa)
            }

            override fun onFailure(call: Call<InfoGempaDirasakan>, t: Throwable) {
                Log.e("RemoteDataSource", "getGempaDirasakan onFailure : ${t.message}")
            }

        })
    }

    fun getGempamagnitudo(callback: LoadGempaMagnitudo){
        val client = ApiConfig.getApiService().getMagnitudo()
        client.enqueue(object : Callback<InfoGempaMagnitudo>{
            override fun onResponse(
                    call: Call<InfoGempaMagnitudo>,
                    response: Response<InfoGempaMagnitudo>
            ) {
                callback.onLoadedGempaMagnitudo(response.body()?.infogempa?.gempa)
            }

            override fun onFailure(call: Call<InfoGempaMagnitudo>, t: Throwable) {
                Log.e("RemoteDataSource", "getGempamagnitudo onFailure : ${t.message}")
            }

        })
    }

    interface LoadGempaTerkini{
        fun onLoadedGempaTerkini(gempaTerkini: TerkiniResponse)
    }

    interface LoadGempaDirasakan{
        fun onLoadedGempaDirasakan(gempaDirasakan: List<DirasakanResponse>?)
    }

    interface LoadGempaMagnitudo{
        fun onLoadedGempaMagnitudo(gempaMagnitudo: List<MagnitudoResponse>?)
    }

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource()
            }
    }
}