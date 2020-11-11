package com.mbds.news.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mbds.news.R
import com.mbds.news.adapters.ArticleAdapter
import com.mbds.news.api.repository.ArticleRpository
import com.mbds.news.api.repository.CountryArticlepository
import com.mbds.news.model.Article
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ArticlesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CountryArticlesFragment : Fragment() {

    lateinit var repository:CountryArticlepository


    override fun onCreateView (
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        return inflater.inflate(R.layout.fragment_articles, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        super.onViewCreated(view, savedInstanceState)

        val urlEditeur=arguments?.getString("urlCountry")

        repository = urlEditeur?.let { CountryArticlepository(it)}!!


        lifecycleScope.launch(Dispatchers.IO) {
            getData(view)
        }
    }

    private suspend fun getData(view: View) {
        withContext(Dispatchers.IO) {
            val result = repository?.listCountryArticle()

            bindData(result!!.articles,view)

        }
    }

    //S'execute sur le thread principal
    private suspend fun bindData(result: List<Article>, view: View) {
        withContext(Dispatchers.Main) {


            val recyclerView: RecyclerView = view.findViewById(R.id.recycler_articles)

            val adapterRecycler=ArticleAdapter(result)
            recyclerView.hasFixedSize()
            recyclerView.layoutManager = LinearLayoutManager(view.context)
            recyclerView.adapter = adapterRecycler
        }
    }

    companion object {
        fun newInstance(url:String): CountryArticlesFragment {

            val   urlNewInstance=url
            val fragment= CountryArticlesFragment()
            val args = Bundle()
            args.putString("urlCountry",urlNewInstance)

            fragment.arguments=args
            return fragment
        }
    }
}