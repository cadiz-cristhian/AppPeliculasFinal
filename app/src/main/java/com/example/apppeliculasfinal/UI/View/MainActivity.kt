package com.example.apppeliculasfinal.UI.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apppeliculasfinal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // se declara el ViewBinding
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // se setea el viewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getSupportActionBar()?.hide();
        binding.btnIngresar.setOnClickListener { siguienteAc() }

    }

    // metodo para el boton
    fun siguienteAc() {
        val intent = Intent(this, InicioUsuario::class.java)
        startActivity(intent)

    }



}