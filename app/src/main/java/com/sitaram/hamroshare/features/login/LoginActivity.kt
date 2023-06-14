package com.sitaram.hamroshare.features.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.sitaram.hamroshare.MainActivity
import com.sitaram.hamroshare.R
import com.sitaram.hamroshare.features.register.RegisterActivity

class LoginActivity : AppCompatActivity(), LoginContract.View {

    private var loginButton: Button? = null
    private var editTextName: EditText? = null
    private var editTextPassword: EditText? = null
    private var loginPresenter: LoginPresenter? = null
    // private var databaseHelper: DatabaseHelper? = null
    private var tvRegister: TextView? = null
    private var autoCompleteTVBank: AutoCompleteTextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginPresenter = LoginPresenter(this, this)
        // databaseHelper = DatabaseHelper(this)

        // dropdown text fields
        autoCompleteTVBank = findViewById(R.id.autoCompleteTextView)
        val banks = resources.getStringArray(R.array.bank_name)
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, banks)
        autoCompleteTVBank?.setAdapter(arrayAdapter)

        // initialize the variable
        loginButton = findViewById(R.id.btnLogin)
        tvRegister = findViewById(R.id.tvRegister)
        editTextName = findViewById(R.id.inputTextUsername)
        editTextPassword = findViewById(R.id.inputTextPassword)

        // register text
        tvRegister?.setOnClickListener {
            navigateToRegister()
        }

        // login button setOnClickListener method
        loginButton?.setOnClickListener {
            userLogin()
        }
    }

    // userLogin function
    private fun userLogin() {
        val name = editTextName?.text.toString().trim()
        val password = editTextPassword?.text.toString().trim()
        loginPresenter?.setLoginDetails(name, password)
    }

    // success message
    override fun successMessage(message: String?) {
        // toast message
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    // failed/error message
    override fun errorMessage(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    // navigate function
    override fun navigateToHome() {
        // explicit intent use to navigate home activity
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    // navigate function
    private fun navigateToRegister() {
        // explicit intent use to navigate register activity
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }
}