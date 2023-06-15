package com.sitaram.hamroshare.features.register

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.sitaram.hamroshare.R
import com.sitaram.hamroshare.features.database.DatabaseHelper
import com.sitaram.hamroshare.features.login.LoginActivity

class RegisterActivity : AppCompatActivity(), RegisterContract.View {

    // variable declare
    private var editTextEmail: EditText? = null
    private var editTextUsername: EditText? = null
    private var editTextUserPassword: EditText? = null
    private var registerPresenter: RegisterPresenter? = null
    private var databaseHelper: DatabaseHelper? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        registerPresenter = RegisterPresenter(this, this)
        databaseHelper = DatabaseHelper(this)

        // initialize the variable
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextUsername = findViewById(R.id.editTextUsername)
        editTextUserPassword = findViewById(R.id.editTextUserPassword)
        val btnSignUp = findViewById<Button>(R.id.btnSignUp)
        val btnBack = findViewById<Button>(R.id.btnBack)

        // back button setOnClickListener
        btnBack.setOnClickListener {
            navigateTOLogin()
        }

        // register button setOnClickListener
        btnSignUp?.setOnClickListener {
            registerDetails()
        }
    }

    // register user details
    private fun registerDetails(){
        val email = editTextEmail?.text.toString().trim()
        val username = editTextUsername?.text.toString().trim()
        val userPassword = editTextUserPassword?.text.toString().trim()
        registerPresenter?.getRegisterDetails(email, username, userPassword)
    }

    // success message
    override fun registerSuccessMessage(message: String) {
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
    }

    // un-success message
    override fun registerErrorMessage(message: String) {
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
    }

    // navigate to login activity
    override fun navigateTOLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    override fun register(email: String, username: String, password: String): Boolean? {
        return databaseHelper?.registerUser(email, username, password)
    }
}