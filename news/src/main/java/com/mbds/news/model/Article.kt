package com.mbds.news.model

data class Article(
        var source:Source?,
        val title:String?,
        val urlToImage: String?,
        val author: String?,
        val description: String?,
        val content: String?,
        val url:String?
)