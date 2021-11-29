package com.example.pendeteksigempadantsunami.ui.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.pendeteksigempadantsunami.R
import com.example.pendeteksigempadantsunami.databinding.ActivitySplashScreenBinding
import com.example.pendeteksigempadantsunami.ui.home.MainActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activitySplashScreenBinding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(activitySplashScreenBinding.root)

        val waktu: Long = 3000
        Handler(Looper.getMainLooper()).postDelayed({

            val intent = Intent(this@SplashScreen, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, waktu)

    }

    private lateinit var activitySplashScreenBinding : ActivitySplashScreenBinding
}