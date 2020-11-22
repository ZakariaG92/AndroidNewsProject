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
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ChoiceCategorie = intent.extras
        var value = ""// or other values

        if (ChoiceCategorie != null) {
            value = ChoiceCategorie.getString("key").toString()
            //value2 = ChoiceCategorie2?.getString("ArticleCountryUrl").toString()


           when (value) {
               "Par catégories"-> { changeFragment(CategoriesFragement()) }
               "Sports"-> { changeFragment(ArticlesFragmentSport()) }
               "Economy"-> { changeFragment(ArticlesFragmentEconomy()) }
               "Politics"-> { changeFragment(ArticlesFragmentPolitique()) }
               "News"-> { changeFragment(ArticlesFragmentNews()) }
               "Par éditeurs"-> { changeFragment(EditeurFragment()) }
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






                   if (fragmentDetail != null) {
                       changeFragment(fragmentDetail)
                   }
               }
               }
        }else {changeFragment(HomeFragment())}
        //}else {changeFragment(EditeursFragment())}
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