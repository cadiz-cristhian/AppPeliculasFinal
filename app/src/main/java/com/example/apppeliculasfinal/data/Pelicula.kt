package com.example.apppeliculasfinal.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Pelicula_entity")
data class Pelicula(
    @PrimaryKey(autoGenerate = true)
    val id: String,
                    val nombre: String,
                    val fecha: String,
                    val director: String,
                    val rating: String,
                    val genero: String,
                    val imagen: String)
{

}
