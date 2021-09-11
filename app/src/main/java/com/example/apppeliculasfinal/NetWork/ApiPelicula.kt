package com.example.apppeliculasfinal.NetWork

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiPelicula {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://cristhian.rayunmapu.cl/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}