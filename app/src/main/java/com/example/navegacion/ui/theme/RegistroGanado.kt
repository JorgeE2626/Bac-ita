package com.example.navegacion.ui.theme

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.navegacion.R

class RegistroGanadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_ganado)

        val cb = findViewById<CheckBox>(R.id.cbNacidaRancho)
        val padre = findViewById<EditText>(R.id.etPadre)
        val madre = findViewById<EditText>(R.id.etMadre)

        // Mostrar/Ocultar padres
        cb.setOnCheckedChangeListener { _, isChecked ->
            padre.visibility = if (isChecked) View.VISIBLE else View.GONE
            madre.visibility = if (isChecked) View.VISIBLE else View.GONE
        }

        // Registrar
        findViewById<Button>(R.id.btnRegistrar).setOnClickListener {
            Toast.makeText(this, "Ganado registrado exitosamente ✅", Toast.LENGTH_LONG).show()
        }

        // 🔗 IR A ACTUALIZAR DATOS
        findViewById<Button>(R.id.btnActualizar).setOnClickListener {
            startActivity(Intent(this, ActualizarDatosActivity::class.java))
        }
    }
}
