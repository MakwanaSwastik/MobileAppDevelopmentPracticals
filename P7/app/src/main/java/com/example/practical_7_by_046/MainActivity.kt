package com.example.practical_7_by_046

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import com.example.practical_7_by_046.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initVideoPlayer()
        binding.btnSwith.setOnClickListener{
            Intent(this,YoutubeActivity::class.java).also { startActivity(it) }
        }
    }
    private fun initVideoPlayer()
    {
        val mediaController = MediaController(this)
        val uri: Uri = Uri.parse("android.resource://"+ packageName + "/" + R.raw.thestoryoflight)
        binding.myVideoview.setMediaController(mediaController)
        mediaController.setAnchorView(binding.myVideoview)
        binding.myVideoview.setVideoURI(uri)
        binding.myVideoview.requestFocus()
        binding.myVideoview.start()
    }
}
