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
import com.mbds.news.adapters.CountryAdapter
import com.mbds.news.api.repository.Countrypository
import com.mbds.news.model.Country
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
class CountryFragment : Fragment() {
    private val repository = Countrypository()

    override fun onCreateView (
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        return inflater.inflate(R.layout.fragment_country, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)


        lifecycleScope.launch(Dispatchers.IO) {
            getData(view)
        }

    }


    private suspend fun getData(view: View) {
        withContext(Dispatchers.IO) {
            val result = repository.listCountry()
            bindData(result!!.sources,view)
        }
    }
    //S'execute sur le thread principal
    private suspend fun bindData(result: List<Country>, view: View) {
        withContext(Dispatchers.Main) {


            val a:List<Country>
            a=result.distinct()
            val recyclerView: RecyclerView = view.findViewById(R.id.recycler_country)

            val adapterRecycler=CountryAdapter(a)
            recyclerView.hasFixedSize()
            recyclerView.layoutManager = LinearLayoutManager(view.context)
            recyclerView.adapter = adapterRecycler


        }
    }
}
