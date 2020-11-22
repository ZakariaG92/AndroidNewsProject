package com.mbds.news.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mbds.news.Dao.AppDatabase
import com.mbds.news.R
import com.mbds.news.adapters.ArticleAdapter
import com.mbds.news.adapters.CategoriAdapter
import com.mbds.news.adapters.FavorisAdapter
import com.mbds.news.model.Article
import com.mbds.news.model.Category
import kotlinx.coroutines.*

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FavorisFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FavorisFragment : Fragment() {

     var  articlesList= listOf<Article>()

    override fun onCreateView (
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favoris, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        lifecycleScope.launch(Dispatchers.IO) {
            getData(view)
        }





    }


    private suspend fun getData(view: View) {
        withContext(Dispatchers.IO) {


            val  db = AppDatabase.getAppDataBase(context = view.context)
            var articleDao = db?.articleDao()

            val result =   articleDao?.getArticles()

            bindData(result!!,view)
        }
    }
    //S'execute sur le thread principal
    private suspend fun bindData(result: List<Article>, view: View) {
        withContext(Dispatchers.Main) {

            val recyclerView: RecyclerView = view.findViewById(R.id.recycler_favoris)

            val adapterRecycler= FavorisAdapter(result)
            recyclerView.hasFixedSize()
            recyclerView.layoutManager = LinearLayoutManager(view.context)
            recyclerView.adapter = adapterRecycler

        }
    }


}