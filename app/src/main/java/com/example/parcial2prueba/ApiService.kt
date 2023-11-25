package com.example.parcial2prueba

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {

    @GET
    suspend fun getFruits(@Url url: String): Response <MutableList<DetailFruit>>

    @GET
    suspend fun getDetailByFruit(@Url url: String): Response <DetailFruit>
}