package com.example.p9

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.p9.R.id.image_heart

class MainActivity : AppCompatActivity() {
    private lateinit var alarmAnimation: AnimationDrawable
    private lateinit var heartAnimation: AnimationDrawable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val `image-alarm` = findViewById<ImageView>(R.id.imagealarm)
        `image-alarm`.setBackgroundResource(R.drawable.alarm_animation_list)
        alarmAnimation=`image-alarm`.background as AnimationDrawable

        val `image-heart` = findViewById<ImageView>(image_heart)
        `image-heart`.setBackgroundResource(R.drawable.heart_animation_list)
        heartAnimation=`image-heart`.background as AnimationDrawable
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        if (hasFocus) {
            alarmAnimation.start()
            heartAnimation.start()
        } else {
            alarmAnimation.stop()
            heartAnimation.stop()
        }

        super.onWindowFocusChanged(hasFocus)
    }
}