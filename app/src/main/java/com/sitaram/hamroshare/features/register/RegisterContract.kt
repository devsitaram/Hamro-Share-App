package com.sitaram.sqlitedatabasekotlin.features.register

interface RegisterContract {
    // create the interface view class
        interface View {
            fun registerSuccessMessage(message: String)
            fun registerErrorMessage(message: String)
            fun navigateTOLogin()
        }

        // interface Presenter
        interface Presenter {
            fun getRegisterDetails(email: String, username: String, password: String)
        }

        // interface Model
        interface Model {
            fun setRegister(email: String, username: String, password: String): Boolean?
        }
}