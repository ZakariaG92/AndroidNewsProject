package com.mbds.news.api

import com.mbds.news.model.Article
import com.mbds.news.model.ArticleResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryName
import retrofit2.http.Url

interface ArticleService {
    var i:String



    @GET("everything?q=economy&apiKey=fbab359f05f040b7aa7e2bcb7925d3ac")
    fun listEconomy(): Call<ArticleResponse>

    @GET("everything?q=sport&apiKey=fbab359f05f040b7aa7e2bcb7925d3ac")
    fun listSport(): Call<ArticleResponse>

    @GET("everything?q=economy&apiKey=fbab359f05f040b7aa7e2bcb7925d3ac")
    fun listNews(): Call<ArticleResponse>

    @GET("everything?q=politic&apiKey=fbab359f05f040b7aa7e2bcb7925d3ac")
    fun listPolitique(): Call<ArticleResponse>

    // Pour les articles PAR EDITEUR
    @GET()
    fun listEditeurArticle(@Url url:String): Call<ArticleResponse>
}