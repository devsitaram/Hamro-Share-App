package com.sitaram.hamroshare.features.api

import android.telecom.Call
import com.sitaram.hamroshare.features.stock.helper.StockPojo
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiServices {

    // local server data
    @Headers(
        *["X-RapidAPI-Key: 71bf5ec090msha9ecf2d7b476478p1f2533jsnd5cef4e5ef55",
            "X-RapidAPI-Host: book4.p.rapidapi.com"])
    @GET("price/")
    fun getBooks(): retrofit2.Call<StockPojo>?
}