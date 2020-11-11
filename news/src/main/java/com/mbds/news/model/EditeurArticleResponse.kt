package com.mbds.news.model

data class EditeurArticleResponse(
    val status:String,
    val totalResults: Int,
    val articles:List<Article>
)