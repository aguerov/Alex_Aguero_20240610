package com.microdesarrollo.alex_aguero_20240610

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class JugadorAdapter(private val context: Context, private val jugadores: ArrayList<Jugador>) : BaseAdapter() {

    override fun getCount(): Int {
        return jugadores.size
    }

    override fun getItem(position: Int): Any {
        return jugadores[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_jugador, parent, false)

        val jugador = jugadores[position]

        val imageView: ImageView = view.findViewById(R.id.imageViewJugador)
        val textViewNombre: TextView = view.findViewById(R.id.textViewNombre)
        val textViewEquipo: TextView = view.findViewById(R.id.textViewEquipo)
        val textViewGoles: TextView = view.findViewById(R.id.textViewGoles)

        imageView.setImageResource(jugador.imagenResId)
        textViewNombre.text = jugador.nombre
        textViewEquipo.text = jugador.equipo
        textViewGoles.text = "Goles: ${jugador.goles}"

        return view
    }
}
