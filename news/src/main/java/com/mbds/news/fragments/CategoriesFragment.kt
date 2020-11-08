package com.mbds.news.fragments



import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mbds.news.R
import com.mbds.news.adapters.CategoriAdapter
import com.mbds.news.model.Category
import com.mbds.news.api.repository.*
import com.mbds.news.model.Article
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext




/**
 * A simple [Fragment] subclass.
 * Use the [CategoriesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CategoriesFragement : Fragment() {


    override fun onCreateView (
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_categories, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        val articles: List<Category> = listOf<Category>(
            Category("Editeurs", "https://i.picsum.photos/id/367/4928/3264.jpg?hmac=H-2OwMlcYm0a--Jd2qaZkXgFZFRxYyGrkrYjupP8Sro"),
            Category("Politics", "https://i.picsum.photos/id/3/5616/3744.jpg?hmac=QSuBxtSpEv3Qm3iStn2b_Ikzj2EVD0jzn99m1n6JD9I"),
            Category("Sports", "https://i.picsum.photos/id/1058/4608/3072.jpg?hmac=kfHIsJ4T3b-ily0CcdGESnuC4wwOPtnOQpcICheyvFQ"),
            Category("Economy", "https://i.picsum.photos/id/274/3824/2520.jpg?hmac=OOl_w8LX_psogyruUe1z986AuqeS_TY7rLxAFgG4wrc"),
            Category("News", "https://i.picsum.photos/id/367/4928/3264.jpg?hmac=H-2OwMlcYm0a--Jd2qaZkXgFZFRxYyGrkrYjupP8Sro")
            )
        val adapterRecycler = CategoriAdapter(articles)
        recyclerView.hasFixedSize()
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = adapterRecycler





    }



}