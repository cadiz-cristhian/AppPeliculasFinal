package com.example.apppeliculasfinal.UI.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
import com.example.apppeliculasfinal.R
import com.example.apppeliculasfinal.UI.Adapters.DataBaseAdapter
import com.example.apppeliculasfinal.UI.Adapters.PeliculaAdapter
import com.example.apppeliculasfinal.UI.ViewModel.DataBaseViewModel
import com.example.apppeliculasfinal.UI.ViewModel.PeliculaViewModel
import com.example.apppeliculasfinal.data.database.PeliculaEntidad
import com.example.apppeliculasfinal.databinding.ActivityPeliculasGuardadasBinding
import com.example.apppeliculasfinal.databinding.ActivityResultadoBinding
import com.example.apppeliculasfinal.databinding.RecyclerviewPeliculasguardadasBinding

class PeliculasGuardadas : AppCompatActivity(), DataBaseAdapter.RowClickListener {

    // se declara el ViewBinding
    private lateinit var binding : ActivityPeliculasGuardadasBinding
    lateinit var recyclerViewAdapter: DataBaseAdapter
    lateinit var viewModel: DataBaseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPeliculasGuardadasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getSupportActionBar()?.hide();
        initRecyclerView()
        initViewModel()

        }

    override fun onDeletePeliculaClickListener(pelicula: PeliculaEntidad) {
        viewModel.eliminarPelicula(pelicula)
    }
    override fun onItemClickListener(pelicula: PeliculaEntidad) {
        TODO("Not yet implemented")
    }
    fun initRecyclerView()
    {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerViewAdapter = DataBaseAdapter(this@PeliculasGuardadas,this@PeliculasGuardadas)
        binding.recyclerView.adapter = recyclerViewAdapter
    }
    fun initViewModel()
    {
        viewModel = ViewModelProvider(this).get(DataBaseViewModel::class.java)
        viewModel.allPeliculas.observe(this, Observer {
            if(it != null) {
                recyclerViewAdapter.setListPelicula(ArrayList(it))
                recyclerViewAdapter.notifyDataSetChanged()
            }else {
                Toast.makeText(this, "Error al cargar la lista", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.getAllPeliculas()
    }
    }

