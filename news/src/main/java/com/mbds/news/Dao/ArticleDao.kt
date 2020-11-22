package com.mbds.news.Dao

import androidx.room.*
import com.mbds.news.model.Article

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArticle(article: Article)

    @Update
    fun updateArticle(article: Article)

    @Delete
    fun deleteArticle(article: Article)


    @Query("SELECT * FROM Article")
    fun getArticles(): List<Article>
}