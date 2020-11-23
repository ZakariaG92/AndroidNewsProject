package com.mbds.news.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mbds.news.R
import com.mbds.news.model.Team


class  AboutusAdapter(private val dataset: List<Team>) :
    RecyclerView.Adapter<AboutusAdapter.ViewHolder>() {

    class ViewHolder(val root: View) : RecyclerView.ViewHolder(root) {


        fun bind(item:Team ) {
            val txtname = root.findViewById<TextView>(R.id.us_name)
            val imageView = root.findViewById<ImageView>(R.id.us_image)

            txtname.text = item.name






            Glide
                    .with(root)
                    .load(item.image)
                    .centerInside()
                    .placeholder(R.drawable.placeholder)
                    .into(imageView);
        }




    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_us, parent, false)
        return ViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataset[position])
    }

    override fun getItemCount(): Int = dataset.size



}

