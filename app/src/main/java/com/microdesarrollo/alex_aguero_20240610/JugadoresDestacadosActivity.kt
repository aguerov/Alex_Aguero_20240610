package com.microdesarrollo.alex_aguero_20240610

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class JugadoresDestacadosActivity : AppCompatActivity() {

    private lateinit var adapter: JugadorAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jugadores_destacados)

        val listView: ListView = findViewById(R.id.listViewJugadores)
        val jugadores = JugadorData.jugadores

        adapter = JugadorAdapter(this, jugadores)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val jugador = jugadores[position]
            jugador.goles++
            adapter.notifyDataSetChanged()
            if (position == 1) {
                // Abre VideoActivity para el segundo jugador
                val intent = Intent(this, VideoActivity::class.java)
                startActivity(intent)
            }
            // Muestra mensaje de gol anotado
            Toast.makeText(this, "Gol anotado por ${jugador.nombre}", Toast.LENGTH_SHORT).show()
        }

        val btnVolver: Button = findViewById(R.id.btnVolver)
        btnVolver.setOnClickListener {
            finish()
        }

        val btnVerGrafico: Button = findViewById(R.id.btnVerGrafico)
        btnVerGrafico.setOnClickListener {
            val intent = Intent(this, GraficoGoleadoresActivity::class.java)
            startActivity(intent)
        }
    }
}
