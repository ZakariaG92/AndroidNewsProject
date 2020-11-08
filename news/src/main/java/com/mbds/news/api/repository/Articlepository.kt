package com.mbds.news.api.repository

import com.mbds.news.api.ArticleService
import com.mbds.news.model.Article
import com.mbds.news.model.ArticleResponse
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ArticleRpository {


    private val service: ArticleService
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

        service = retrofit.create(ArticleService::class.java)
    }




    fun listSport(): ArticleResponse? {
        val response = service.listSport().execute()
        return response.body() ?: null
    }

    fun listEconomy(): ArticleResponse? {
        val response = service.listEconomy().execute()
        return response.body() ?: null
    }

    fun listNews(): ArticleResponse? {
        val response = service.listNews().execute()
        return response.body() ?: null
    }

    fun listPolitique(): ArticleResponse? {
        val response = service.listPolitique().execute()
        return response.body() ?: null
    }
}




