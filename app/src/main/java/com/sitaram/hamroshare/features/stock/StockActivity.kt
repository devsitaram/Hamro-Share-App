package com.sitaram.hamroshare.features.stock

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sitaram.hamroshare.R
import com.sitaram.hamroshare.features.stock.helper.StockPojo

class StockActivity : AppCompatActivity(), StockContract.View {

    private var stockPresenter: StockPresenter? = null
    var isApiCall = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stock)

        // call the api only one time

        // call the api only one time
        if (isApiCall) {
            // create an object of the bookPresenter class and call the setBook method
            stockPresenter = StockPresenter(this, this)
            stockPresenter?.setStock()
            isApiCall = false
        }
    }

    // show the success message
    override fun aipSuccessMessage(success: String) {
        Toast.makeText(this, success, Toast.LENGTH_SHORT).show()
    }

    // show the error message
    override fun aipErrorMessage(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    override fun setStock(body: StockPojo?) {
        TODO("Not yet implemented")
    }
}