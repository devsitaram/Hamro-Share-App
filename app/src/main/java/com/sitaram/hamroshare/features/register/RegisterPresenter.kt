package com.sitaram.hamroshare.features.register

import android.content.Context

class RegisterPresenter: RegisterContract.Presenter {

    private var context: Context? = null
    private var view: RegisterContract.View? = null
    private var registerModel: RegisterModel? = RegisterModel()

    // secondary constructor
    constructor(context: Context?, view: RegisterContract.View) {
        this.context = context
        this.view = view
    }

    // register function
    override fun getRegisterDetails(email: String, username: String, password: String) {
        if (email.isEmpty() || username.isEmpty() || password.isEmpty()) {
            view?.registerErrorMessage("The fields is empty!")
        } else {
            register(email, username, password)
        }
    }

    // register user details
    private fun register(email: String, username: String, password: String){
        // val isRegisterSuccess: Boolean? = registerModel?.setRegister(email, username, password)

        val isRegisterSuccess = view?.register(email, username, password)
        if (isRegisterSuccess == true) {
            view?.registerSuccessMessage("Register successfully.")
            view?.navigateTOLogin()
        } else {
            view?.registerErrorMessage("Enter the valid details!")
        }
    }

}