package com.example.apppeliculasfinal.Domain

import com.example.apppeliculasfinal.NetWork.RepositorioPeliculas
import com.example.apppeliculasfinal.data.Pelicula

class GetPeliculas // ESTA CLASE SIRVE PARA RECUPERAR LA LISTA DEL .JSON
{
    private val repository = RepositorioPeliculas()
    suspend operator fun invoke():List<Pelicula>? = repository.getAllPeliculas()
}