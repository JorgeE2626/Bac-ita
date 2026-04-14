package com.example.navegacion.ui.theme

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.navegacion.R
import java.text.SimpleDateFormat
import java.util.*

class ActualizarDatosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar_datos)

        val fecha = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
        findViewById<EditText>(R.id.etFecha).setText(fecha)

        findViewById<Button>(R.id.btnActualizar).setOnClickListener {
            Toast.makeText(this, "Datos actualizados correctamente ✅", Toast.LENGTH_LONG).show()
        }
    }
}
