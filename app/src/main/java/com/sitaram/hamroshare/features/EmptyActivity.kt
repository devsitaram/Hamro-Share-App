package com.sitaram.hamroshare.features

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.sitaram.hamroshare.R

class EmptyActivity : AppCompatActivity() {

    private var autoCompleteTextView: AutoCompleteTextView? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empty)

        //
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView)

        val banks = resources.getStringArray(R.array.bank_name)
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, banks)
        autoCompleteTextView?.setAdapter(arrayAdapter)
    }
}