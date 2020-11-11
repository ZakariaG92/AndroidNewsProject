package com.mbds.news.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.mbds.news.R
import com.mbds.news.model.Article

class  ArticleAdapter(private val dataset: List<Article>) :
    RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {


    class ViewHolder(val root: View) : RecyclerView.ViewHolder(root) {


        fun bind(item: Article) {
            var artName = root.findViewById<TextView>(R.id.article_name)
            var artImage = root.findViewById<ImageView>(R.id.article_image)
            var artDescription = root.findViewById<TextView>(R.id.article_description)
            // buttonArticle.setText(item.name)


            artName.setText(item.title)
            artDescription.setText(item.description)

            Glide
                .with(root)
                .load(item.urlToImage)
                .centerInside()
                .placeholder(R.drawable.placeholder2)
                .into(artImage);
        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item2, parent, false)
        return ViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataset[position])
    }

    override fun getItemCount(): Int = dataset.size




}