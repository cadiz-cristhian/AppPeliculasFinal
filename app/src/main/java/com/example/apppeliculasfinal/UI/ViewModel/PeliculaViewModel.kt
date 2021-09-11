package com.example.apppeliculasfinal.UI.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apppeliculasfinal.NetWork.RepositorioPeliculas
import com.example.apppeliculasfinal.data.Pelicula
import kotlinx.coroutines.launch

//  Para que nuestra clase sea un ViewModel, tenemos que hacer que la clase creada extienda de dicha clase y es por ello que ponemos : ViewModel() después del nombre de la clase.

class PeliculaViewModel : ViewModel() {
    val peliculamodel = MutableLiveData<List<Pelicula>>()
    val repo = RepositorioPeliculas()


    fun onCreate() {
        viewModelScope.launch {
            //isLoading.postValue(true)
            val result = repo.getAllPeliculas()
            if(!result.isNullOrEmpty()){
                peliculamodel.postValue(result)
               // isLoading.postValue(false)
            }
        }
    }
    fun seleccionaTerror()
    {
        viewModelScope.launch {
            //isLoading.postValue(true)
            val result = repo.getPeliculasTerror()
            if(!result.isNullOrEmpty()){
                peliculamodel.postValue(result)
                // isLoading.postValue(false)
            }
        }
    }
    fun seleccionaComedia()
    {
        viewModelScope.launch {
            //isLoading.postValue(true)
            val result = repo.getPeliculasComedia()
            if(!result.isNullOrEmpty()){
                peliculamodel.postValue(result)
                // isLoading.postValue(false)
            }
        }
    }
    fun seleccionaDrama()
    {
        viewModelScope.launch {
            //isLoading.postValue(true)
            val result = repo.getPeliculasDrama()
            if(!result.isNullOrEmpty()){
                peliculamodel.postValue(result)
                // isLoading.postValue(false)
            }
        }
    }
    fun seleccionaAccion()
    {
        viewModelScope.launch {
            //isLoading.postValue(true)
            val result = repo.getPeliculasAccion()
            if(!result.isNullOrEmpty()){
                peliculamodel.postValue(result)
                // isLoading.postValue(false)
            }
        }
    }


}