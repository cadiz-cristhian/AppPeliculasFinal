package com.example.apppeliculasfinal.UI.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.apppeliculasfinal.UI.ViewModel.PeliculaViewModel
import com.example.apppeliculasfinal.databinding.ActivityOpcionesBinding

class Opciones : AppCompatActivity() {
    // se declara el ViewBinding
    private lateinit var binding : ActivityOpcionesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // se setea el viewBinding
        binding = ActivityOpcionesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getSupportActionBar()?.hide();





    }
}