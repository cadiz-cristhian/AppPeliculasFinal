package com.example.apppeliculasfinal.UI.ViewModel

import android.app.Application
import androidx.lifecycle.*
import com.example.apppeliculasfinal.data.database.PeliculaDatabase
import com.example.apppeliculasfinal.data.database.PeliculaEntidad

class DataBaseViewModel(app : Application): AndroidViewModel(app) {
    lateinit var allPeliculas : MutableLiveData<List<PeliculaEntidad>>
    init {
        allPeliculas = MutableLiveData()
    }
    fun getAllUsersObservers() : MutableLiveData<List<PeliculaEntidad>>
    {
        return allPeliculas
    }
    fun getAllPeliculas()
    {
        val peliculaDao = PeliculaDatabase.getDataBase((getApplication()))?.peliculaDao()
        val list = peliculaDao?.obtenerPeliculas()
        allPeliculas.postValue(list)
    }
    fun insertarPelicula(entidad : PeliculaEntidad){
        val peliculadao = PeliculaDatabase.getDataBase((getApplication()))?.peliculaDao()
        peliculadao?.agregarLista(entidad)
        getAllPeliculas()
    }
    fun updatePelicula(entidad : PeliculaEntidad){
        val peliculadao = PeliculaDatabase.getDataBase((getApplication()))?.peliculaDao()
        peliculadao?.updatePelicula(entidad)
        getAllPeliculas()
    }
    fun eliminarPelicula(entidad : PeliculaEntidad){
        val peliculadao = PeliculaDatabase.getDataBase((getApplication()))?.peliculaDao()
        peliculadao?.eliminarPelicula(entidad)
        getAllPeliculas()
    }
}