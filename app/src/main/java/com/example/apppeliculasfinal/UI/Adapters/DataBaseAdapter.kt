package com.example.apppeliculasfinal.UI.Adapters

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.apppeliculasfinal.R
import com.example.apppeliculasfinal.data.Pelicula
import com.example.apppeliculasfinal.data.database.PeliculaEntidad
import com.example.apppeliculasfinal.databinding.PeliculaRecyclerviewBinding
import com.example.apppeliculasfinal.databinding.RecyclerviewPeliculasguardadasBinding
import com.squareup.picasso.Picasso

class DataBaseAdapter (private val activity : Activity, val listener : RowClickListener): RecyclerView.Adapter<DataBaseAdapter.DataBaseHolder>() {
    var items = ArrayList<PeliculaEntidad>()

    fun setListPelicula(data: ArrayList<PeliculaEntidad>){
        this.items = data
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBaseAdapter.DataBaseHolder {
        val binding: RecyclerviewPeliculasguardadasBinding = RecyclerviewPeliculasguardadasBinding.inflate(
            LayoutInflater.from(activity)
        )
        return DataBaseHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: DataBaseAdapter.DataBaseHolder, position: Int) {
        holder.itemView.setOnClickListener{
            listener.onItemClickListener(items[position])
        }
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class DataBaseHolder(view : RecyclerviewPeliculasguardadasBinding, val listener : RowClickListener) : RecyclerView.ViewHolder(view.root) {
        val titulo = view.txtNombrePelicula
        val director = view.txtNombreDirector
        val fecha = view.txtfecha
        val imagen = view.ivPoster
        val eliminar = view.txtEliminar

        fun bind(data: PeliculaEntidad){
            titulo.text = data.nombre
            director.text = data.director
            fecha.text = data.fecha
            Picasso.get().load(data.imagen).into(imagen)

            eliminar.setOnClickListener {
                    listener.onDeletePeliculaClickListener(data)
            }
        }
    }
    interface RowClickListener{
        fun onDeletePeliculaClickListener(pelicula : PeliculaEntidad)
        fun onItemClickListener(pelicula : PeliculaEntidad)
    }


}