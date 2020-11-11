package com.mbds.news.api.repository

import com.mbds.news.api.CountryService
import com.mbds.news.model.CountryResponse
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Countrypository {


    private val service: CountryService
    init {

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        val retrofit = Retrofit.Builder().apply {
            baseUrl("https://newsapi.org/v2/")
//            client(client)
            addConverterFactory(GsonConverterFactory.create())
        }.build()

        service = retrofit.create(CountryService::class.java)
    }

    fun listCountry(): CountryResponse? {
        val response = service.listCountry().execute()
        return response.body() ?: null
    }

}