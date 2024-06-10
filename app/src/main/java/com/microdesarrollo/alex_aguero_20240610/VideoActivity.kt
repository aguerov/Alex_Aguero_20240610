package com.microdesarrollo.alex_aguero_20240610

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class VideoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        val videoView: VideoView = findViewById(R.id.videoView)
        val uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.sample_video)
        videoView.setVideoURI(uri)
        videoView.start()

        val btnVolver: Button = findViewById(R.id.btnVolver)
        btnVolver.setOnClickListener {
            finish()
        }
    }
}
