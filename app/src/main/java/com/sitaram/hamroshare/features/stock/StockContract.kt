package com.sitaram.hamroshare.features.stock

interface StockContract {

    // create the interface view class
    interface View {
        fun aipSuccessMessage(success: String)
        fun aipErrorMessage(error: String)
        fun setStock(body: StockPojo)
    }

    // interface Presenter
    interface Presenter {
        fun getStock()

    }

    // interface Model
    interface Model {
        fun setStock()
    }
}