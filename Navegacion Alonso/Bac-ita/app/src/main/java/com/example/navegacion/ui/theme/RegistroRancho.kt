package com.example.navegacion.ui.theme

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.navegacion.R

class RegistroRanchoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_rancho)

        val spinner = findViewById<Spinner>(R.id.spinnerFoto)
        val img = findViewById<ImageView>(R.id.imgRancho)

        val opciones = arrayOf("Foto", "Agregar foto", "Eliminar foto")
        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, opciones)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p: AdapterView<*>, v: View?, pos: Int, id: Long) {
                if (pos == 2) img.setImageDrawable(null)
            }
            override fun onNothingSelected(p0: AdapterView<*>) {}
        }

        findViewById<Button>(R.id.btnGuardar).setOnClickListener {
            Toast.makeText(this, "Rancho registrado exitosamente ✅", Toast.LENGTH_LONG).show()
        }

        findViewById<Button>(R.id.btnEliminar).setOnClickListener {
            findViewById<EditText>(R.id.etNombre).text.clear()
        }

        findViewById<Button>(R.id.btnRegistrarGanado).setOnClickListener {
            startActivity(Intent(this, RegistroGanadoActivity::class.java))
        }

        findViewById<ImageView>(R.id.mapa).setOnClickListener {
            val uri = Uri.parse("geo:0,0?q=San Francisco de los Romo")
            startActivity(Intent(Intent.ACTION_VIEW, uri))
        }
    }
}