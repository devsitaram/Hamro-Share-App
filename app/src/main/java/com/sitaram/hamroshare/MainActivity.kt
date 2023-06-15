package com.sitaram.hamroshare

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.sitaram.hamroshare.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}







// use the postDelayed
//        Handler().postDelayed({
//            val intentSlider = Intent(this, SliderActivity::class.java)
//            startActivity(intentSlider)
//            finish()
//        }, 1500)