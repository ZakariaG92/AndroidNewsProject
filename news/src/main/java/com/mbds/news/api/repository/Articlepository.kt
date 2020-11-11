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

    val apiKey:String="&apiKey=fbab359f05f040b7aa7e2bcb7925d3ac"
    lateinit var url:String


    constructor(url:String){
    this.url="everything?q="+url
}


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




    fun listQuery(): ArticleResponse? {
        val response = service.listQuery(url+apiKey).execute()
        return response.body() ?: null
    }


}




