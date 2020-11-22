package com.mbds.news.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Article(
        @PrimaryKey(autoGenerate = true)
        val id: Int? = null,
        @Embedded
        var source:Source?,
        val title:String?,
        val urlToImage: String?,
        val author: String?,
        val description: String?,
        val content: String?,
        val url:String?
)