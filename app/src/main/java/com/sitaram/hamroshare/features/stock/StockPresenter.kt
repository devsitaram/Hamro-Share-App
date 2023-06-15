package com.sitaram.hamroshare.features.stock

import android.content.Context
import android.util.Log
import com.sitaram.hamroshare.features.stock.helper.StockPojo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StockPresenter: StockContract.Presenter {

    var context: Context? = null
    var view: StockContract.View? = null
    private val stockModel: StockModel = StockModel()

    constructor(context: Context, view: StockContract.View){
        this.context = context
        this.view = view
    }

    override fun setStock() {
        stockModel.getStock()?.enqueue(object : Callback<StockPojo?> {
            override fun onResponse(call: Call<StockPojo?>, response: Response<StockPojo?>) {
                if (response.isSuccessful) {
                    // set the response is setBook with response.body()
                    view?.setStock(response.body())
                    view?.aipSuccessMessage("Api call Success.")
                } else {
                    // show error message
                    view?.aipErrorMessage("Api call BookPojo is unsuccessful.")
                }
            }

            // display the failed message
            override fun onFailure(call: Call<StockPojo?>, throwable: Throwable) {
                throwable.printStackTrace()
                Log.d("onFailure", "Api call BookPojo is fails: $throwable")
            }
        })
    }
}