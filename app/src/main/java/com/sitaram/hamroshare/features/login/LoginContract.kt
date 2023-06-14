package com.sitaram.hamroshare.features.login

interface LoginContract {

    // create the interface view class
    interface View {
        fun successMessage(message: String?)
        fun errorMessage(message: String?)
        fun navigateToHome()
    }

    // interface Presenter
    interface Presenter {
        fun setLoginDetails(username: String, password: String)
    }

    // interface Model
    interface Model {
        fun getUserDetails(username: String, password: String): Boolean?
    }
}