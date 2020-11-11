package com.mbds.news.api.repository

import com.mbds.news.api.ArticleService
import com.mbds.news.model.ArticleResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EditeursArticlepository {

    lateinit var url: String

    constructor(value: String) {
        this.url = value
    }

    private val service: ArticleService

    init {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        val retrofit = Retrofit.Builder().apply {
            //val baseUrl = "https://newsapi.org/v2/"
            baseUrl("https://newsapi.org/v2/")
            addConverterFactory(GsonConverterFactory.create())
        }.build()

        service = retrofit.create(ArticleService::class.java)
    }


    fun listEditeurArticle(): ArticleResponse? {
        val response = service.listEditeurArticle(url).execute()
        return response.body() ?: null
    }
}




