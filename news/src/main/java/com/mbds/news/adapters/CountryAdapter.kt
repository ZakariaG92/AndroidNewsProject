package com.mbds.news.adapters

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mbds.news.MainActivity
import com.mbds.news.model.Country
import com.mbds.news.R
import com.mbds.news.model.Category


class  CountryAdapter(private val dataset: List<Country>) :
    RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

    class ViewHolder(val root: View) : RecyclerView.ViewHolder(root) {


        fun bind(item:Country ) {
            val txtname = root.findViewById<TextView>(R.id.country_name)
            val imageView = root.findViewById<ImageView>(R.id.country_image)


/*
            imageView.setOnClickListener {

                val intent = Intent(imageView.context, MainActivity::class.java)
                var  b:Bundle  = Bundle()

                when(txtname.text){

                    "Sports"-> {
                        b.putString("key", "Sports")//Your id
                        intent.putExtras(b)//Put your id to your next Intent
                        imageView.context.startActivity(intent)
                    }

                    "Economy"-> {
                        b.putString("key", "Economy")//Your id
                        intent.putExtras(b)//Put your id to your next Intent
                        imageView.context.startActivity(intent)
                    }

                    "Politics"-> {
                        b.putString("key", "Politics")//Your id
                        intent.putExtras(b)//Put your id to your next Intent
                        imageView.context.startActivity(intent)
                    }

                    "News"-> {
                        b.putString("key", "News")//Your id
                        intent.putExtras(b)//Put your id to your next Intent
                        imageView.context.startActivity(intent)
                    }

                }

            }


*/

            txtname.text = item.name

            Glide
                .with(root)
                .load(item.image)
                .centerInside()
                .placeholder(R.drawable.placeholder)
                .into(imageView);
        }
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryAdapter.ViewHolder {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_pays, parent, false)
        return CountryAdapter.ViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: CountryAdapter.ViewHolder, position: Int) {
        holder.bind(dataset[position])
    }

    override fun getItemCount(): Int = dataset.size
}