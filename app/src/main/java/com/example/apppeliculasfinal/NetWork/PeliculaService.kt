package com.example.apppeliculasfinal.NetWork

import com.example.apppeliculasfinal.data.Pelicula
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PeliculaService {
    private val retrofit = ApiPelicula.getRetrofit()

    suspend fun getPelicula() : List<Pelicula>
    {
        return withContext(Dispatchers.IO)
        {
            val response = retrofit.create(ApiClient::class.java).getMovies()
            response.body() ?: emptyList()
        }
    }
}