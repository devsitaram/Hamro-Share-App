package com.sitaram.hamroshare.features.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiCallInstance {

    companion object {
        private var retrofit: Retrofit? = null
        private const val BASE_URL = "https://latest-stock-price.p.rapidapi.com/" // api base url
    }

    // create the instance of Retrofit
    fun getRetrofitInstance(): Retrofit? {
        if (retrofit == null) {
            // create the object of httpLoggingInterceptor
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

            // create object of okHttpClient
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build()

            // create an object of the retrofit
            retrofit = Retrofit.Builder()
                .baseUrl(Companion.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create()) // converter
                .build()
        }
        // return the retrofit
        return retrofit
    }
}