package com.example.apppeliculasfinal.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.apppeliculasfinal.data.Pelicula
import kotlinx.coroutines.flow.Flow

@Dao
interface PeliculaDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun agregarLista (pelicula : PeliculaEntidad?)

    @Query("SELECT * FROM pelicula ORDER BY id DESC")
    fun obtenerPeliculas() : List<PeliculaEntidad>?

    @Delete
    fun eliminarPelicula(pelicula : PeliculaEntidad?)

    @Update
    fun updatePelicula(pelicula: PeliculaEntidad?)


}
