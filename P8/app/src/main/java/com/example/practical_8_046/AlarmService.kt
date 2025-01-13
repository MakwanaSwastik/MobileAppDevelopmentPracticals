package com.example.practical_8_046

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class AlarmService : Service() {
    private lateinit var player: MediaPlayer
    override fun onBind(intent: Intent): IBinder? {
        // TODO: Implement communication channel if needed.
        return null
    }

    override fun onDestroy() {
        player.stop()
        super.onDestroy()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent != null) {
            player = MediaPlayer.create(this, R.raw.alarm)
            player.start()
        }
        return START_STICKY
    }
}