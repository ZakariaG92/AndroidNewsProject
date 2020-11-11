package com.mbds.news.api

import com.mbds.news.model.Article
import com.mbds.news.model.ArticleResponse
import com.mbds.news.model.CountryResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryName


interface CountryService {
    @GET("sources?apiKey=fbab359f05f040b7aa7e2bcb7925d3ac")
    fun listCountry(): Call<CountryResponse>
}