package com.example.apppeliculasfinal.UI.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.apppeliculasfinal.databinding.ActivityInicioUsuarioBinding

class InicioUsuario : AppCompatActivity() {

    private lateinit var binding : ActivityInicioUsuarioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInicioUsuarioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getSupportActionBar()?.hide();
    }

    // metodo para el boton
    fun pasarOpciones(view: View?) {
        val crashButton = Button(this)
        crashButton.text = "Test Crash"
        crashButton.setOnClickListener {
            throw RuntimeException("Test Crash") // Force a crash
        }

        addContentView(crashButton, ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT))
    }

    fun pasarCuestionario(view: View?) {
        val siguiente = Intent(this, CuestionarioView::class.java)
        startActivity(siguiente)
    }

    fun pasarRevisar(view: View?) {
        val siguiente = Intent(this, PeliculasGuardadas::class.java)
        startActivity(siguiente)
    }
}