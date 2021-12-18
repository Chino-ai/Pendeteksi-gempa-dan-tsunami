package com.zaelani.pendeteksigempadantsunami.network

import com.zaelani.pendeteksigempadantsunami.data.remote.response.dirasakan.InfoGempaDirasakan
import com.zaelani.pendeteksigempadantsunami.data.remote.response.magnitudo.InfoGempaMagnitudo
import com.zaelani.pendeteksigempadantsunami.data.remote.response.terkini.InfoGempaTerkini
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("gempadirasakan.json")
    fun getDirasakan(): Call<InfoGempaDirasakan>

    @GET("gempaterkini.json")
    fun getMagnitudo(): Call<InfoGempaMagnitudo>

    @GET("autogempa.json")
    fun getTerkini(): Call<InfoGempaTerkini>
}