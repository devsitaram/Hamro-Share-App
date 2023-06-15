package com.sitaram.hamroshare.features.stock

import com.sitaram.hamroshare.features.api.ApiCallInstance
import com.sitaram.hamroshare.features.api.ApiServices
import com.sitaram.hamroshare.features.stock.helper.StockPojo
import retrofit2.Call
import retrofit2.Retrofit

class StockModel: StockContract.Model {

    override fun getStock(): Call<StockPojo>? {
        val retrofit: Retrofit = ApiCallInstance.getRetrofitInstance()
        return retrofit.create(ApiServices::class.java).getBooks()
    }
}