package com.mbds.news.fragments



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mbds.news.R
import com.mbds.news.adapters.CategoriAdapter
import com.mbds.news.adapters.CountryAdapter
import com.mbds.news.model.Country
import com.mbds.news.model.Article
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext




/**
 * A simple [Fragment] subclass.
 * Use the [CategoriesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CountryFragment : Fragment() {


    override fun onCreateView (
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_country, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        val articles: List<Country> = listOf<Country>(
            Country("Argentina", "https://cdn.countryflags.com/thumbs/argentina/flag-800.png"),
            Country("Australia", "https://cdn.countryflags.com/thumbs/australia/flag-800.png"),
            Country("Egypte", "https://cdn.countryflags.com/thumbs/egypt/flag-800.png"),
            Country("France", "https://cdn.countryflags.com/thumbs/france/flag-800.png"),
            Country("Italy", "https://cdn.countryflags.com/thumbs/italy/flag-800.png"),
            Country("Japan", "https://cdn.countryflags.com/thumbs/japan/flag-800.png"),
            Country("Morocco", "https://cdn.countryflags.com/thumbs/morocco/flag-800.png"),
            Country("Netherlands", "https://cdn.countryflags.com/thumbs/netherlands/flag-800.png"),
            Country("South Africa", "https://cdn.countryflags.com/thumbs/south-africa/flag-800.png"),
            Country("United Arab Emirates", "https://cdn.countryflags.com/thumbs/united-arab-emirates/flag-800.png"),
            Country("United Kingdom", "https://cdn.countryflags.com/thumbs/united-kingdom/flag-800.png"),
            Country("United States", "https://cdn.countryflags.com/thumbs/united-states-of-america/flag-800.png")

        )
        val adapterRecycler = CountryAdapter(articles)
        recyclerView.hasFixedSize()
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = adapterRecycler





    }



}