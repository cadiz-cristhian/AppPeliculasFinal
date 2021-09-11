package com.example.apppeliculasfinal.UI.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.apppeliculasfinal.R
import com.example.apppeliculasfinal.data.Pelicula
import com.example.apppeliculasfinal.data.PeliculaProvider
import com.example.apppeliculasfinal.data.PreguntaProvider
import com.example.apppeliculasfinal.databinding.ActivityCuestionarioViewBinding
import com.example.apppeliculasfinal.databinding.ActivityOpcionesBinding
import java.util.HashMap

class CuestionarioView : AppCompatActivity() {

    // se declara el ViewBinding
    private lateinit var binding : ActivityCuestionarioViewBinding

    //declaran variables
    private var contador = 0
    private var ischeck = false
    var contadorTerror = 0
    var contadorAccion = 0
    var contadorDrama = 0
    var contadorComedia = 0
    var generoElegido: String? = null
    var resp = HashMap<Int, Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // se setea el viewBinding
        binding = ActivityCuestionarioViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnFinalizar.setVisibility(View.INVISIBLE)
        getSupportActionBar()?.hide();
        rellenarDatos(contador)

        //Metodo para el boton, checkea si está seleccionada alguna opción
        binding.btnSiguientePregunta.setOnClickListener(View.OnClickListener {
            if (binding.rbRespuestaA.isChecked()) {
                ischeck = true
                contadorTerror = contadorTerror + 1
            } else if (binding.rbRespuestaB.isChecked()) {
                ischeck = true
                contadorComedia = contadorComedia + 1
            } else if (binding.rbRespuestaC.isChecked()) {
                ischeck = true
                contadorDrama = contadorDrama + 1
            } else if (binding.rbRespuestaD.isChecked()) {
                ischeck = true
                contadorAccion = contadorAccion + 1
            } else {
                val toast = Toast.makeText(
                    applicationContext,
                    "Debe seleccionar una respuesta",
                    Toast.LENGTH_SHORT
                )
                toast.show()
            }
            if (true.also { ischeck = it }) {
                if (contador < 4) // si ya respondió las preguntas se pasa a mostrar el resultado
                {
                    binding.rgRespuestas.clearCheck()
                    contador = contador + 1
                    rellenarDatos(contador)
                } else {
                    resultado()
                    binding.btnSiguientePregunta.setVisibility(View.INVISIBLE)
                    binding.btnFinalizar.setVisibility(View.VISIBLE)
                    binding.btnFinalizar.setEnabled(true)
                    binding.btnFinalizar.setOnClickListener { pasarResultado()  }
                }
            }
        })
    }
    fun rellenarDatos(numP: Int) {
        val cc = PreguntaProvider()

        for (i in 0 until cc.arrayPregunta.size) {
            val idPregunta: Int = cc.arrayPregunta.get(i).idPregunta
            if (idPregunta == numP) {
                val p: String = cc.arrayPregunta.get(i).pregunta
                val a: String = cc.arrayPregunta.get(i).a
                val b: String = cc.arrayPregunta.get(i).b
                val c: String = cc.arrayPregunta.get(i).c
                val d: String = cc.arrayPregunta.get(i).d
                binding.txtPregunta.setText(p)
                binding.rbRespuestaA.setText("A: " + a)
                binding.rbRespuestaB.setText("B: $b")
                binding.rbRespuestaC.setText("C: $c")
                binding.rbRespuestaD.setText("D: $d")
            }
        }
    }
    fun resultado() {
        val numeros = intArrayOf(contadorTerror, contadorComedia, contadorDrama, contadorAccion)
        // Asumir que el mayor es el primero
        var mayor = numeros[0]
        // Recorrer arreglo y ver si no es así
        // (comenzar desde el 1 porque el 0 ya lo tenemos contemplado arriba)
        for (x in 1 until numeros.size) {
            if (numeros[x] > mayor) {
                mayor = numeros[x]
            }
            if (mayor == contadorTerror) {
                generoElegido = "Terror"
            } else if (mayor == contadorComedia) {
                generoElegido = "Comedia"
            } else if (mayor == contadorDrama) {
                generoElegido = "Drama"
            } else if (mayor == contadorAccion) {
                generoElegido = "Acción"
            }
        }
    }
    fun pasarResultado() {
        val intent = Intent(this@CuestionarioView, Resultado::class.java)
        intent.putExtra("Genero", generoElegido)
        startActivity(intent)
    }
}