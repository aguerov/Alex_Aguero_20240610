package com.microdesarrollo.alex_aguero_20240610

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry

class GraficoGoleadoresActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grafico_goleadores)

        val barChart: BarChart = findViewById(R.id.barChart)
        val jugadores = JugadorData.jugadores

        val entries = ArrayList<BarEntry>()
        for ((index, jugador) in jugadores.withIndex()) {
            entries.add(BarEntry(index.toFloat(), jugador.goles.toFloat()))
        }

        val dataSet = BarDataSet(entries, "Goles")
        val barData = BarData(dataSet)
        barChart.data = barData
        barChart.invalidate() // refresca la gráfica

        val btnVolver: Button = findViewById(R.id.btnVolver)
        btnVolver.setOnClickListener {
            finish()
        }
    }
}

