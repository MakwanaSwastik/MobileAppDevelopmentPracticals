package com.example.p9

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.AnimationUtils
import android.widget.ImageView

class SplashActivity : AppCompatActivity(), Animation.AnimationListener {

    private lateinit var frameAnimation: AnimationDrawable
    private lateinit var logoImage: ImageView
    private lateinit var twinAnimation: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        logoImage = findViewById(R.id.uvpce)
        logoImage.setBackgroundResource(R.drawable.logo_animation_list)

        frameAnimation = logoImage.background as AnimationDrawable
        twinAnimation = AnimationUtils.loadAnimation(this, R.anim.twin_animation)
        twinAnimation.setAnimationListener(this)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            // Start the frame-by-frame animation
            startFrameAnimation()
        } else {
            frameAnimation.stop()
        }
    }

    private fun startFrameAnimation() {
        if (frameAnimation.isRunning) {
            frameAnimation.stop()
        }
        frameAnimation.start()

        // Calculate the duration of the frame-by-frame animation
        val frameAnimationDuration = calculateFrameAnimationDuration(frameAnimation)

        // Schedule the twin animation to start after the frame-by-frame animation finishes
        logoImage.postDelayed({
            logoImage.startAnimation(twinAnimation)
        }, frameAnimationDuration)
    }

    private fun calculateFrameAnimationDuration(animationDrawable: AnimationDrawable): Long {
        val frameCount = animationDrawable.numberOfFrames
        var duration = 0L
        for (i in 0 until frameCount) {
            duration += animationDrawable.getDuration(i)
        }
        return duration
    }

    override fun onAnimationStart(p0: Animation?) {
        // Code for onAnimationStart, if needed
    }

    override fun onAnimationEnd(p0: Animation?) {
        // Animation has finished in the SplashActivity
        // Start the MainActivity
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

        // Close the SplashActivity to prevent going back to it with the back button
        finish()
    }

    override fun onAnimationRepeat(p0: Animation?) {
        // Code for onAnimationRepeat, if needed
    }
}