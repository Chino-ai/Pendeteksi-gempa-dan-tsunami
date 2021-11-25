package com.example.pendeteksigempadantsunami.data.API


import com.example.pendeteksigempadantsunami.data.remote.response.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("gempadirasakan.json")
    fun getDirasakan(

    ): Call<DirasakanResponse>

    @GET("{gempaterkini.json}")
    fun getMagnitudo(

    ): Call<MagnitudoResponse>

    @GET("{autogempa.json}")
    fun getTerkini(

    ): Call<TerkiniResponse>
}

