package com.mbds.news

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.mbds.news.fragments.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ChoiceCategorie = intent.extras

        var value = ""// or other values

        if (ChoiceCategorie != null) {
            value = ChoiceCategorie.getString("key").toString()

            when (value) {
                "Sports"-> { changeFragment(ArticlesFragmentSport()) }
                "Economy"-> { changeFragment(ArticlesFragmentEconomy()) }
                "Politics"-> { changeFragment(ArticlesFragmentPolitique()) }
                "News"-> { changeFragment(ArticlesFragmentNews()) }
                "Details"-> {
                    val articleData= ChoiceCategorie.getStringArray("Article");
                    //val title=  articleDataBundle?.getString("title")

                    val fragmentDetail=  ArticleDetailFragment.newInstance(articleData!!.get(0),articleData!!.get(1),articleData!!.get(2),articleData!!.get(3),articleData!!.get(4))
                    changeFragment(fragmentDetail)
                }
            }
        }else {changeFragment(CategoriesFragement())}






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

