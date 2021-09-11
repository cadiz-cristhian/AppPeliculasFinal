package com.example.apppeliculasfinal.UI.Adapters

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.apppeliculasfinal.UI.View.CuestionarioView
import com.example.apppeliculasfinal.UI.View.Detalle
import com.example.apppeliculasfinal.data.Pelicula
import com.example.apppeliculasfinal.databinding.PeliculaRecyclerviewBinding
import com.squareup.picasso.Picasso

class PeliculaAdapter(private val activity : Activity) : RecyclerView.Adapter<PeliculaViewHolder>() {
    private var peliculas: List<Pelicula> = listOf()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculaViewHolder {
        val binding: PeliculaRecyclerviewBinding = PeliculaRecyclerviewBinding.inflate(
            LayoutInflater.from(activity)
        )
        return PeliculaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PeliculaViewHolder, position: Int) {
        val pelicula = peliculas[position]
            holder.director.text = pelicula.director
            holder.nombre.text = pelicula.nombre
            //Picasso.get().load(pelicula.imagen).into(holder.imagen)
        Glide.with(activity).load(pelicula.imagen).apply(RequestOptions().override(70,70)).into(holder.imagen)
        // Pasar activida detalle
        holder.detalle.setOnClickListener{
            val siguiente = Intent(activity, Detalle::class.java)
            siguiente.putExtra("Titulo",pelicula.nombre)
            siguiente.putExtra("Imagen",pelicula.imagen)
            siguiente.putExtra("Director",pelicula.director)
            siguiente.putExtra("Fecha",pelicula.fecha)
            activity.startActivity(siguiente)
        }

        }
    fun cargarPeliculas(list: List<Pelicula>) {
        peliculas = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return peliculas.size
    }



}
