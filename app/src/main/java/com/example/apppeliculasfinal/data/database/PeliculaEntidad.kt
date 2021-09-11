package com.example.apppeliculasfinal.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pelicula")
data class PeliculaEntidad(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id:Int = 0,
    @ColumnInfo(name = "titulo") val nombre: String,
    @ColumnInfo(name = "fecha") val  fecha: String,
    @ColumnInfo(name = "director") val  director: String,
    @ColumnInfo(name = "imagen") val  imagen: String)
