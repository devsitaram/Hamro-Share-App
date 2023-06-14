package com.sitaram.hamroshare

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.sitaram.hamroshare.features.splash.SliderActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // use the postDelayed

        // use the postDelayed
        Handler().postDelayed({
            val intentSlider = Intent(this, SliderActivity::class.java)
            startActivity(intentSlider)
            finish()
        }, 1500)
    }
}