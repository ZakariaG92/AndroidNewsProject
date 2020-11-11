package com.mbds.news

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.mbds.news.fragments.*
import java.time.temporal.ValueRange

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ChoiceCategorie = intent.extras

       lateinit var value:String

        if (ChoiceCategorie != null) {
            value = ChoiceCategorie.getString("key").toString()

            when (value) {
                "Articles"-> {
                    println("****************************************")
                    println(value)
                    val url = ChoiceCategorie.getString("url").toString()
                    val fragmentArticle= ArticlesFragment.newInstance(url)
                    changeFragment(fragmentArticle)
                }

//                "Details"-> {
//                    println("****************************************")
//                    println(value)
//                    val articleData= ChoiceCategorie.getStringArray("Article");
//                    //val title=  articleDataBundle?.getString("title")
//
//                    val fragmentDetail=  ArticleDetailFragment.newInstance(articleData!!.get(0),articleData!!.get(1),articleData!!.get(2),articleData!!.get(3),articleData!!.get(4))
//                    changeFragment(fragmentDetail)
//                }
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