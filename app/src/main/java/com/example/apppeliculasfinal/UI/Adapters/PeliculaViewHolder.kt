package com.example.apppeliculasfinal.UI.Adapters

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.apppeliculasfinal.UI.View.Detalle
import com.example.apppeliculasfinal.databinding.PeliculaRecyclerviewBinding

class PeliculaViewHolder (view : PeliculaRecyclerviewBinding) : RecyclerView.ViewHolder(view.root){

    val imagen = view.ivPoster
    val nombre = view.txtNombrePelicula
    val director = view.txtNombreDirector
    val detalle = view.txtRevisar

}

