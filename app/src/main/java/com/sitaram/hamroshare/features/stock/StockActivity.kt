package com.sitaram.hamroshare.features.stock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.sitaram.hamroshare.R

class StockActivity : AppCompatActivity(), StockContract.View {

    private var stockPresenter: StockPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stock)
        stockPresenter = StockPresenter(this, this)
    }

    override fun setStock(body: StockPojo) {

    }
    override fun aipSuccessMessage(success: String) {
        Toast.makeText(this, success, Toast.LENGTH_SHORT).show()
    }

    override fun aipErrorMessage(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }
}