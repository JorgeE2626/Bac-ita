package com.example.navegacion

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AvisoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aviso)

        val btnAceptar = findViewById<Button>(R.id.btnAceptar)
        val btnRechazar = findViewById<Button>(R.id.btnRechazar)

        btnAceptar.setOnClickListener {
            // 👉 Va al login
            startActivity(Intent(this, LoginActivity::class.java))
        }

        btnRechazar.setOnClickListener {
            finish()
        }
    }
}