package com.mbds.news.adapters

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mbds.news.MainActivity

import com.mbds.news.R
import com.mbds.news.changeFragment
import com.mbds.news.model.Article

class  ArticleAdapter(private val dataset: List<Article>) :
        RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {


    class ViewHolder(val root: View) : RecyclerView.ViewHolder(root) {


        fun bind(item: Article) {
            var artName = root.findViewById<TextView>(R.id.article_name)
            var artImage = root.findViewById<ImageView>(R.id.article_image)
            var artDescription = root.findViewById<TextView>(R.id.article_description)
            var artDate = root.findViewById<TextView>(R.id.article_date)
            // buttonArticle.setText(item.name)


            artName.setText(item.title)
            artDescription.setText(item.description)
            artDate.setText("date")

            artImage.setOnClickListener {

                val intent = Intent(artImage.context, MainActivity::class.java)
                var  articleMetadata: Bundle = Bundle()


                val articleData = arrayOf(item.title,item.urlToImage,item.content,item.author, item.url)

                articleMetadata.putString("key","Details")
                articleMetadata.putStringArray("Article",articleData)

                intent.putExtras(articleMetadata)//Put your id to your next Intent
                artImage.context.startActivity(intent)





            }

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

