package com.example.apppeliculasfinal.NetWork

import com.example.apppeliculasfinal.data.Pelicula
import com.example.apppeliculasfinal.data.PeliculaProvider

class RepositorioPeliculas {
    private val api = PeliculaService()
    private var peliculas = PeliculaProvider.peliculas

    suspend fun getAllPeliculas():List<Pelicula>{
        val response = api.getPelicula()
        //recupera la lista de internet y se la asigna a la lista del provider
        peliculas = response
        return response
    }
    // recuperar lista según el genero
    suspend fun getPeliculasTerror(): List<Pelicula> {
        val response = api.getPelicula()
        var genero: MutableList<Pelicula> = mutableListOf()
        peliculas = response
        response.forEach {
            if (it.genero.equals("Terror")) {
                genero.add(it)
            }
        }
        return genero
    }
    suspend fun getPeliculasComedia(): List<Pelicula> {
        val response = api.getPelicula()
        var genero: MutableList<Pelicula> = mutableListOf()
        peliculas = response
        response.forEach {
            if (it.genero.equals("Comedia")) {
                genero.add(it)
            }
        }
        return genero
    }
    suspend fun getPeliculasAccion(): List<Pelicula> {
        val response = api.getPelicula()
        var genero: MutableList<Pelicula> = mutableListOf()
        peliculas = response
        response.forEach {
            if (it.genero.equals("Acción")) {
                genero.add(it)
            }
        }
        return genero
    }
    suspend fun getPeliculasDrama(): List<Pelicula> {
        val response = api.getPelicula()
        var genero: MutableList<Pelicula> = mutableListOf()
        peliculas = response
        response.forEach {
            if (it.genero.equals("Drama")) {
                genero.add(it)
            }
        }
        return genero
    }
    suspend fun getPeliculaElegida(titulo : String) : List<Pelicula>
    {
        val response = api.getPelicula()
        var elegida: MutableList<Pelicula> = mutableListOf()
        peliculas = response
        response.forEach {
            if (it.nombre.equals(titulo)) {
                elegida.add(it)
            }
        }
        return elegida
    }


}