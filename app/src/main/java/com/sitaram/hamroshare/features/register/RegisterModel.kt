package com.sitaram.sqlitedatabasekotlin.features.register

class RegisterModel: RegisterContract.Model {

    override fun setRegister(email: String, username: String, password: String): Boolean? {
        return true
    }
}