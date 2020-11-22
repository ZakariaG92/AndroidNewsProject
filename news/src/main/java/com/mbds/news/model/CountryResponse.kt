package com.mbds.news.model

data class CountryResponse (
    val status:String,
    val totalResults: Int,
    val sources:List<Country>
)