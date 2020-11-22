package com.mbds.news

import android.app.Application
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.mbds.news.Dao.AppDatabase
import com.mbds.news.fragments.*
import com.mbds.news.model.Article
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.temporal.ValueRange

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ChoiceCategorie = intent.extras

       lateinit var value:String


//        var article1:Article= Article(null, null,"titre",null,"gasmi","desc","contenu",null)
//
//      val  db = AppDatabase.getAppDataBase(context = this)
//       var articleDao = db?.articleDao()
//
//        articleDao?.insertArticle(article1)

        lifecycleScope.launch(Dispatchers.IO) {


            println("*************************************************************************")

            println("lyfecycle")

            println("*************************************************************************")
                    var article1:Article= Article(1, null,"titre",null,"gasmi","desc","contenu",null)



      val  db = AppDatabase.getAppDataBase(context = application.baseContext)
       var articleDao = db?.articleDao()

        //articleDao?.insertArticle(article1)

        }

        if (ChoiceCategorie != null) {
            value = ChoiceCategorie.getString("key").toString()
            value2 = ChoiceCategorie2?.getString("ArticleCountryUrl").toString()


            when (value) {
                "Articles"-> {
                    println("****************************************")
                    println(value)
                    val url = ChoiceCategorie.getString("url").toString()
                    val fragmentArticle= ArticlesFragment.newInstance(url)
                    changeFragment(fragmentArticle)
                }

                "Details"-> {
                    println("****************************************")
                    println(value)
                    val articleData= ChoiceCategorie.getStringArray("Article");
                    //val title=  articleDataBundle?.getString("title")

                    val fragmentDetail=  ArticleDetailFragment.newInstance(articleData!!.get(0),articleData!!.get(1),articleData!!.get(2),articleData!!.get(3),articleData!!.get(4))
                    changeFragment(fragmentDetail)
                }
                "Editeurs"-> { changeFragment(EditeurFragment()) }
                "EditeursArticles"-> {
                    lateinit  var  fragmentDetail:EditeurArticlesFragment
                    val urlEditeur= ChoiceCategorie.getString("ArticleEditeurUrl");
                    //val title=  articleDataBundle?.getString("title")

                    if (urlEditeur!=null) { fragmentDetail=  EditeurArticlesFragment.newInstance(urlEditeur)}

                    if (fragmentDetail != null) {
                        changeFragment(fragmentDetail)
                    }
                }
                "CountryArticles"-> {
                    lateinit  var  fragmentDetail:CountryArticlesFragment
                    val urlCountry= ChoiceCategorie2?.getString("ArticleCountryUrl");
                    //val title=  articleDataBundle?.getString("title")

                    if (urlCountry!=null) { fragmentDetail=  CountryArticlesFragment.newInstance(urlCountry)}

                    if (fragmentDetail != null) {
                        changeFragment(fragmentDetail)
                    }
                }
                "Favoris"-> { changeFragment(FavorisFragment())}
            }
        }
        else {
            println("****************************************")
            println("Categorie")
            changeFragment(CategoriesFragement())}






    }
}

/**
 * Ajouter le fragmet [ComputationFragment] dans l'activité
 */
fun MainActivity.changeFragment(fragment: Fragment) {
    supportFragmentManager.beginTransaction().apply {
        //3) on remplace le contenu du container
        replace(R.id.fragment_container, fragment)
        //4) on ajoute la transaction dans la backstack
       // addToBackStack(null)
    }.commit()
    // 5) on commit la transaction
}