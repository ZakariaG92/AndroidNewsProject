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
import com.mbds.news.model.Editeur

class EditeurAdapter(private val dataset: List<Editeur>) :
        RecyclerView.Adapter<EditeurAdapter.ViewHolder>() {

    class ViewHolder(val root: View) : RecyclerView.ViewHolder(root) {


        fun bind(item: Editeur) {
            var editeurName = root.findViewById<TextView>(R.id.editor_name)
            editeurName.setText(item.id)

            editeurName.setOnClickListener {


                val intent = Intent(editeurName.context, MainActivity::class.java)
                var b: Bundle = Bundle()

                when (editeurName.text) {

                    editeurName.text -> {
                        b.putString("key", "EditeursArticles")//Your id
                        b.putString("ArticleEditeurUrl", "top-headlines?sources="+editeurName.text+"&apiKey=fbab359f05f040b7aa7e2bcb7925d3ac")//Your id
                        intent.putExtras(b)//Put your id to your next Intent
                        editeurName.context.startActivity(intent)
                    }
                }

            }
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