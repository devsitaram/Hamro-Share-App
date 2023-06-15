package com.sitaram.hamroshare.features.stock

import com.sitaram.hamroshare.features.stock.helper.StockPojo
import retrofit2.Call

interface StockContract {

    // create the interface view class
    interface View {
        fun aipSuccessMessage(success: String)
        fun aipErrorMessage(error: String)
        fun setStock(body: StockPojo?)
    }

    // interface Presenter
    interface Presenter {
        fun setStock()

    }

    // interface Model
    interface Model {
        fun getStock(): Call<StockPojo>?
    }
}