package com.example.apppeliculasfinal.UI.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.apppeliculasfinal.R
import com.example.apppeliculasfinal.UI.ViewModel.DataBaseViewModel
import com.example.apppeliculasfinal.UI.ViewModel.PeliculaViewModel
import com.example.apppeliculasfinal.data.InformacionProvider
import com.example.apppeliculasfinal.data.database.PeliculaEntidad
import com.example.apppeliculasfinal.databinding.ActivityDetalleBinding
import com.example.apppeliculasfinal.databinding.ActivityOpcionesBinding
import com.google.android.youtube.player.YouTubeStandalonePlayer

class Detalle : AppCompatActivity() {

    // se declara el ViewBinding
    private lateinit var binding : ActivityDetalleBinding
    lateinit var viewModel: DataBaseViewModel
    var informacion : InformacionProvider = InformacionProvider()
    var url: String? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // se setea el viewBinding
        binding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getSupportActionBar()?.hide();
        recibirDatos()
        agregarSinopsis()
        viewModel = ViewModelProvider(this).get(DataBaseViewModel::class.java)

        binding.btnAgregarDb.setOnClickListener {
            agregarADb()
        }
        binding.btnVerTrailer.setOnClickListener {
            reproducirTrailer()
        }

    }

    fun recibirDatos() {
        // se declara variable genero
        var titulo: String? = null
        var fecha: String? = null
        var director: String? = null
        var imagen: String? = null
        var sinopsis: String? = null
        val extras = intent.extras
        titulo = extras!!.getString("Titulo")
        fecha = extras!!.getString("Fecha")
        director = extras!!.getString("Director")
        imagen = extras!!.getString("Imagen")
        binding.txtDetalleTitulo.setText(titulo)
        binding.txtDetalleDirector.setText(director)
        binding.txtDetalleFecha.setText(fecha)
        Glide.with(this).load(imagen).into(binding.imageView)

        }

    fun reproducirTrailer(){
        val siguiente = Intent(this, Youtube::class.java)
        siguiente.putExtra("URL",url)
        startActivity(siguiente)


    }
    fun agregarADb()
    {
        val titulo = binding.txtDetalleTitulo.text.toString()
        val director = binding.txtDetalleDirector.text.toString()
        val fecha = binding.txtDetalleFecha.text.toString()
        val imagen = binding.imageView.toString()

        val pelicula = PeliculaEntidad(0,titulo,fecha,director,imagen)
        viewModel.insertarPelicula(pelicula)
    }
    fun agregarSinopsis()
    {
        var titulo: String? = null
        var pelicula: String? = null
        val extras = intent.extras
        pelicula = extras!!.getString("Titulo")
        informacion.generarInfo()
        informacion.info?.forEach {
            titulo = it.titulo
            if(titulo.equals(pelicula)){
            binding.txtSinopsis.setText(it.info)
                url = it.url
        }
        }


    }

}