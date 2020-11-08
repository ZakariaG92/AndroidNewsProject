package com.mbds.news.api

import com.mbds.news.model.Article
import com.mbds.news.model.ArticleResponse
import com.mbds.news.model.EditeurResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryName

interface EditeurService {

   // @GET("sources?apiKey=fbab359f05f040b7aa7e2bcb7925d3ac")
    @GET("sources?apiKey=fbab359f05f040b7aa7e2bcb7925d3ac")
    fun listEditeurs(): Call<EditeurResponse>

}