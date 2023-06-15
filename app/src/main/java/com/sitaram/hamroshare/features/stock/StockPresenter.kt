package com.sitaram.hamroshare.features.stock

import android.content.Context

class StockPresenter: StockContract.Presenter {

    var context: Context? = null
    var view: StockContract.View? = null
    private val stockModel: StockModel = StockModel()

    constructor(context: Context, view: StockContract.View){
        this.context = context
        this.view = view
    }


    override fun getStock() {
        TODO("Not yet implemented")
    }
}