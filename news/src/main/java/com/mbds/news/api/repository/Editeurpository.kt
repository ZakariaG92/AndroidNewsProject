package com.mbds.news.api.repository

import com.mbds.news.api.EditeurService
import com.mbds.news.model.EditeurResponse
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Editeurpository {


    private val service: EditeurService
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

        service = retrofit.create(EditeurService::class.java)
    }

    fun listEditeurs(): EditeurResponse? {
        val response = service.listEditeurs().execute()
        return response.body() ?: null
    }

}