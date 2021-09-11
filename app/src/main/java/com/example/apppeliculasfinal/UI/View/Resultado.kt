package com.example.apppeliculasfinal.UI.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apppeliculasfinal.UI.Adapters.PeliculaAdapter
import com.example.apppeliculasfinal.UI.ViewModel.PeliculaViewModel
import com.example.apppeliculasfinal.databinding.ActivityResultadoBinding
import com.example.apppeliculasfinal.UI.ViewModel.DataBaseViewModel


class Resultado : AppCompatActivity() {

    // se declara el ViewBinding
    private lateinit var binding : ActivityResultadoBinding
    // se declara el viewModel
    private val peliculaViewModel : PeliculaViewModel by viewModels()
    // se declara el adapter
    lateinit var adapter : PeliculaAdapter



    var genero: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultadoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getSupportActionBar()?.hide();
        recibirDatos()
        initRecyclerView()
        initViewModel()
        binding.btnRegresar.setOnClickListener{regresar()}
    }
    fun recibirDatos() {
        val extras = intent.extras
        genero = extras!!.getString("Genero")
        //binding.textView2.setText(genero)
    }
    private fun initRecyclerView()
    {
        binding.lstPeliculas.layoutManager = LinearLayoutManager(this)
        adapter = PeliculaAdapter(this)
        binding.lstPeliculas.adapter = adapter


    }
    private fun initViewModel()
    {
        val viewModel : PeliculaViewModel = ViewModelProvider(this).get(PeliculaViewModel::class.java)
        viewModel.peliculamodel.observe(this, Observer {
            if(it != null)
            {
                adapter.cargarPeliculas(it)
                adapter.notifyDataSetChanged()
            }else{
                Toast.makeText(this,"Error al cargar la lista", Toast.LENGTH_SHORT).show()
            }
        })
        if(genero.equals("Terror"))
        {
            viewModel.seleccionaTerror()
        }
        if(genero.equals("Comedia"))
        {
            viewModel.seleccionaComedia()
        }
        if(genero.equals("Acción"))
        {
            viewModel.seleccionaAccion()
        }
        if(genero.equals("Drama"))
        {
            viewModel.seleccionaDrama()
        }
    }
    fun regresar() {
        val intent = Intent(this, InicioUsuario::class.java)
        startActivity(intent)
    }

}

