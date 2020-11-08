package com.mbds.news.model

data class EditeurResponse(
    val status:String,
    val totalResults: Int,
    val sources:List<Editeur>
)