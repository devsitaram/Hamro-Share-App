package com.sitaram.hamroshare.features.login

import android.content.Context

class LoginPresenter : LoginContract.Presenter {

    var context: Context? = null
    private var view: LoginContract.View? = null
    private var loginModel: LoginModel? = LoginModel()

    constructor(context: Context?, view: LoginContract.View?) {
        this.context = context
        this.view = view
    }

    override fun setLoginDetails(username: String, password: String) {
        if (username.isEmpty() || password.isEmpty()) {
            view?.errorMessage("The fields is empty!")
        } else {
            loginDetail(username, password)
        }
    }

    private fun loginDetail(username: String, password: String) {
//        val isLoginSuccess: Boolean? = loginModel?.getUserDetails(username, password)

        val isLoginSuccess = view?.login(username, password)

        // check the login is success or not
        if (isLoginSuccess == true) {
            view?.navigateToHome()
            view?.successMessage("Login Successful.")
        } else {
            view?.errorMessage("Please enter the valid details!")
        }
    }
}