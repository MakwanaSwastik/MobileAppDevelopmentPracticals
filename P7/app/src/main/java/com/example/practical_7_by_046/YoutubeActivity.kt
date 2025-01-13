package com.example.practical_7_by_046

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebSettings
import androidx.core.view.WindowCompat
import com.example.practical_7_by_046.databinding.ActivityYoutubeBinding

class YoutubeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityYoutubeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityYoutubeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSwith.setOnClickListener {
            Intent(this, MainActivity::class.java).also { startActivity(it) }
        }

        initYoutubePlayer()
    }
    private val youtubeId = "5yb2N3pnztU"

    private fun initYoutubePlayer() {
        val webSettings: WebSettings = binding.youtubeWebView.settings
        webSettings.javaScriptEnabled = true
        webSettings.loadWithOverviewMode = true
        webSettings.useWideViewPort = true
        binding.youtubeWebView.loadUrl("https://www.youtube.com/embed/$youtubeId")
    }
}