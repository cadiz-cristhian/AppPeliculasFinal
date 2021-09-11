package com.example.apppeliculasfinal.UI.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apppeliculasfinal.NetWork.RepositorioPeliculas
import com.example.apppeliculasfinal.data.Pelicula
import kotlinx.coroutines.launch

class DetalleViewModel : ViewModel() {
    val peliculamodel = MutableLiveData<List<Pelicula>>()
    val repo = RepositorioPeliculas()


}