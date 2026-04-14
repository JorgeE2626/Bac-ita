package com.example.navegacion

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class RecuperarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recuperar)

        val btnCorreo = findViewById<Button>(R.id.btnCorreo)
        val btnCelular = findViewById<Button>(R.id.btnCelular)

        btnCorreo.setOnClickListener {
            startActivity(Intent(this, VerificacionActivity::class.java))
        }

        btnCelular.setOnClickListener {
            startActivity(Intent(this, VerificacionActivity::class.java))
        }
    }
}