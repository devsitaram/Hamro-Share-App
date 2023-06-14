package com.sitaram.hamroshare

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.sitaram.hamroshare.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val language = resources.getStringArray(R.array.bank_name)
//        val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_bank_items, language)
//        binding.autoCompleteTextView.setAdapter(arrayAdapter)
    }
}







// use the postDelayed
//        Handler().postDelayed({
//            val intentSlider = Intent(this, SliderActivity::class.java)
//            startActivity(intentSlider)
//            finish()
//        }, 1500)