package com.example.apppeliculasfinal.NetWork

import com.example.apppeliculasfinal.data.Pelicula
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {
    @GET("peliculas.json")
    suspend fun getMovies() : Response<List<Pelicula>>
}