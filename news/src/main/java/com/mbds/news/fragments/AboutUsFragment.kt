package com.mbds.news.fragments

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mbds.news.R
import com.mbds.news.adapters.AboutusAdapter
import com.mbds.news.model.Team

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AboutUsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AboutUsFragment : Fragment() {

    override fun onCreateView (
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_about_us, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = view.findViewById(R.id.us_view)

        val team: List<Team> = listOf<Team>(
            Team("Jassim EL-HAROUI", "https://media-exp1.licdn.com/dms/image/C4D03AQG-rfdCYbly9g/profile-displayphoto-shrink_200_200/0?e=1611792000&v=beta&t=_Evfc71Ob6jxXolfl_kWrqWXkNLDB_TnlKFfJYmQ7ak"),
            Team("Zakaria GASMI", "https://media-exp1.licdn.com/dms/image/C4D03AQHMAOWw1pHsvg/profile-displayphoto-shrink_400_400/0?e=1611792000&v=beta&t=n4bjU6iGW8BYQlwRLzvzrPNTkurqhtdtaf9kF2p7cSQ" ),
            Team("Nassim Mekkaoui", "https://media-exp1.licdn.com/dms/image/C4D35AQEbJPOdxgr0RA/profile-framedphoto-shrink_200_200/0/1605107699048?e=1606183200&v=beta&t=NZY3J0verzh7bvQkoPc2WvdXr9fTQAOrL3V54R9EmaM")


            )
        val adapterRecycler = AboutusAdapter(team)
        recyclerView.hasFixedSize()
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = adapterRecycler





    }
}