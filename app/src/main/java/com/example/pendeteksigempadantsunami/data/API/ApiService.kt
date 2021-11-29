package com.example.pendeteksigempadantsunami.data.API

import com.example.pendeteksigempadantsunami.data.remote.response.DirasakanResponse
import com.example.pendeteksigempadantsunami.data.remote.response.MagnitudoResponse
import com.example.pendeteksigempadantsunami.data.remote.response.TerkiniResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("gempadirasakan.json")
    fun getDirasakan(): Call<DirasakanResponse>

    @GET("{gempaterkini.json}")
    fun getMagnitudo(): Call<MagnitudoResponse>

    @GET("{autogempa.json}")
    fun getTerkini(): Call<TerkiniResponse>
}

