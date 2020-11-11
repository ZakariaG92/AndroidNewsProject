package com.mbds.news.adapters

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mbds.news.MainActivity
import com.mbds.news.R
import com.mbds.news.model.Country

class CountryAdapter(private val dataset: List<Country>) :
    RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

    class ViewHolder(val root: View) : RecyclerView.ViewHolder(root) {


        fun bind(item: Country) {
            var countryName = root.findViewById<TextView>(R.id.country_name)
            countryName.setText(item.country)

            countryName.setOnClickListener {


                val intent = Intent(countryName.context, MainActivity::class.java)
                var b: Bundle = Bundle()

                when (countryName.text) {

                    countryName.text -> {
                        b.putString("key", "CountryArticles")//Your id
                        b.putString("ArticleCountryUrl", "top-headlines?sources="+countryName.text+"&apiKey=fbab359f05f040b7aa7e2bcb7925d3ac")//Your id
                        intent.putExtras(b)//Put your id to your next Intent
                        countryName.context.startActivity(intent)
                    }
                }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_country, parent, false)
        return ViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataset[position])
    }

    override fun getItemCount(): Int = dataset.size
}
