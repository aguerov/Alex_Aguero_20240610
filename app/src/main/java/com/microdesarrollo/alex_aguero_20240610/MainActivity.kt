package com.microdesarrollo.alex_aguero_20240610

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ViewFlipper
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewFlipper: ViewFlipper = findViewById(R.id.viewFlipper)
        viewFlipper.setInAnimation(this, android.R.anim.fade_in)
        viewFlipper.setOutAnimation(this, android.R.anim.fade_out)
        viewFlipper.startFlipping()

        val btnJugadoresDestacados: Button = findViewById(R.id.btnJugadoresDestacados)
        btnJugadoresDestacados.setOnClickListener {
            val intent = Intent(this, JugadoresDestacadosActivity::class.java)
            startActivity(intent)
        }

        val btnSacarFoto: Button = findViewById(R.id.btnSacarFoto)
        btnSacarFoto.setOnClickListener {
            val intent = Intent(this, CapturarFotoActivity::class.java)
            startActivity(intent)
        }

        val btnVerGrafico: Button = findViewById(R.id.btnVerGrafico)
        btnVerGrafico.setOnClickListener {
            val intent = Intent(this, GraficoGoleadoresActivity::class.java)
            startActivity(intent)
        }
    }
}
