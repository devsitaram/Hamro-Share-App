package com.sitaram.hamroshare.features.splash

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.sitaram.hamroshare.R

@Suppress("DEPRECATION")
@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // use the postDelayed
        Handler().postDelayed({
            val intentSlider = Intent(this, SliderActivity::class.java)
            startActivity(intentSlider)
            finish()
        }, 1000)
    }
}