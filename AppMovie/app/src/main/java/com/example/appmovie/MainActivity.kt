package com.example.appmovie
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var videoView: VideoView
    private lateinit var playButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        videoView = findViewById(R.id.videoView)
        playButton = findViewById(R.id.playButton)

        //val videoPath = "http://SEU_IP_LOCAL:8000/nome_do_video.mp4" // Substitua pelo endereço do vídeo na pasta compartilhada
        val videoPath = "android.resource://" + packageName + "/" + R.raw.gol_falta_messi
        val videoUri = Uri.parse(videoPath)

        // Configurar o MediaController para controlar a reprodução do vídeo
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)

        // Definir a fonte de vídeo e iniciar a reprodução quando o botão for clicado
        videoView.setVideoURI(videoUri)

        playButton.setOnClickListener {
            videoView.start()
        }
    }
}

