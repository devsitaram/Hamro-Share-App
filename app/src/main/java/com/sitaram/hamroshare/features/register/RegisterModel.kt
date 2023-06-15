package com.sitaram.hamroshare.features.register

import com.sitaram.hamroshare.features.register.RegisterContract

class RegisterModel: RegisterContract.Model {

    override fun setRegister(email: String, username: String, password: String): Boolean? {
        return true
    }
}