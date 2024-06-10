# Alex_Aguero_20240610
# Mi Cancha - Administración de Ligas de Futbolito

## Descripción
La aplicación **Mi Cancha** es una solución móvil desarrollada en Kotlin para la administración de distintas ligas de futbolito en la Región Metropolitana. Permite visualizar jugadores destacados, capturar fotos de jugadores y mostrar gráficos de los goleadores de la liga.

## Características
- **Pantalla Inicial con Animación**: Animación de desvanecimiento entre tres imágenes alusivas a ligas de futbolito.
- **Listado de Jugadores Destacados**: Muestra una lista de jugadores con sus fotos y equipos. Al seleccionar un jugador, se incrementa su cantidad de goles y, si es el segundo jugador, se reproduce un video.
- **Captura de Fotos**: Permite capturar fotos de los jugadores destacados y guardarlas en el dispositivo.
- **Gráficos de Goleadores**: Muestra un gráfico de barras con la cantidad de goles anotados por los jugadores.

## Requerimientos
- **Lenguaje**: Kotlin
- **Versión mínima de SDK**: 21 (Lollipop)
- **Versión máxima de SDK**: 34 (Tiramisu)
- **IDE**: Android Studio

## Instalación
1. Clona este repositorio en tu máquina local:
    ```bash
    git clone https://github.com/aguerov/Snake_ADE
    ```
2. Abre el proyecto en Android Studio.
3. Asegúrate de tener las dependencias necesarias en tu archivo `build.gradle`:
    ```groovy
    dependencies {
        implementation 'com.github.PhilJay:MPAndroidChart:v3.1.0'
        // Otras dependencias necesarias
    }
    ```
4. Sincroniza el proyecto para descargar todas las dependencias.

## Uso
### Pantalla Inicial
La pantalla inicial muestra una animación de desvanecimiento entre tres imágenes de futbolito. Contiene botones para acceder a las diferentes funcionalidades de la aplicación.

### Listado de Jugadores Destacados
Al acceder a esta pantalla, se muestra una lista de jugadores destacados con sus fotos y equipos. Al seleccionar un jugador, se incrementa su cantidad de goles. Al seleccionar el segundo jugador, se reproduce un video.

### Captura de Fotos
Esta funcionalidad permite capturar fotos de los jugadores utilizando la cámara del dispositivo y guardarlas en el almacenamiento.

### Gráficos de Goleadores
Esta pantalla muestra un gráfico de barras con la cantidad de goles anotados por los jugadores destacados. Los datos se generan aleatoriamente si no se proporcionan datos.

## Código de Ejemplo
### JugadoresDestacadosActivity
```kotlin
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

# Alex_Aguero_20240610
