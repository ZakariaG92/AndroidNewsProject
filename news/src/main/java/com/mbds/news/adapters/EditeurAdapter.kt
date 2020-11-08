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
import com.mbds.news.model.Editeur

class  EditeurAdapter(private val dataset: List<Editeur>) :
    RecyclerView.Adapter<EditeurAdapter.ViewHolder>() {

    class ViewHolder(val root: View) : RecyclerView.ViewHolder(root) {


        fun bind(item: Editeur) {
            var editeurName = root.findViewById<TextView>(R.id.editor_name)
            editeurName.setText(item.name)
                    }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_editeur, parent, false)
        return ViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataset[position])
    }

    override fun getItemCount(): Int = dataset.size
}