package com.example.pendeteksigempadantsunami.data.remote

import android.util.Log
import com.example.pendeteksigempadantsunami.data.API.ApiConfig
import com.example.pendeteksigempadantsunami.data.local.DirasakanEntity
import com.example.pendeteksigempadantsunami.data.local.MagnitudoEntity
import com.example.pendeteksigempadantsunami.data.remote.response.DirasakanResponse
import com.example.pendeteksigempadantsunami.data.remote.response.GempaItemDirasakan
import com.example.pendeteksigempadantsunami.data.remote.response.GempaItemMagnitudo
import com.example.pendeteksigempadantsunami.data.remote.response.MagnitudoResponse
import com.example.submissionarchitecturecomponent.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource()
            }
    }

        fun getDirasakan(callback: LoadDirasakanCallback) {
            EspressoIdlingResource.increment()
            val client = ApiConfig.getApiService().getDirasakan()
            client.enqueue(object : Callback<DirasakanResponse> {
                override fun onResponse(
                    call: Call<DirasakanResponse>,
                    response: Response<DirasakanResponse>
                ) {

                    callback.onAllDirasakanReceived(response.body()?.gempa)
                    EspressoIdlingResource.decrement()

                }

                override fun onFailure(call: Call<DirasakanResponse>, t: Throwable) {


                    Log.e("RemoteDataSource", "onFailure: ${t.message}")
                    EspressoIdlingResource.increment()

                }

            })
        }

        fun getMagnitudo(callback: LoadMagnitudoCallback) {
            EspressoIdlingResource.increment()
            val client = ApiConfig.getApiService().getMagnitudo()
            client.enqueue(object : Callback<MagnitudoResponse> {
                override fun onResponse(
                    call: Call<MagnitudoResponse>,
                    response: Response<MagnitudoResponse>
                ) {

                    callback.onAllMagnitudoReceived(response.body()?.gempa)
                    EspressoIdlingResource.decrement()

                }

                override fun onFailure(call: Call<MagnitudoResponse>, t: Throwable) {


                    Log.e("RemoteDataSource", "onFailure: ${t.message}")
                    EspressoIdlingResource.increment()

                }

            })
        }

        interface LoadDirasakanCallback {
            fun onAllDirasakanReceived(dirasakanGempa: List<GempaItemDirasakan>?)
        }

        interface LoadMagnitudoCallback {
            fun onAllMagnitudoReceived(magnitudoGempa: List<GempaItemMagnitudo>?)
        }
    }
