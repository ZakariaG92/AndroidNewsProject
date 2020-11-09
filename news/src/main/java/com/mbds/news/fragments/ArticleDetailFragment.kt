package com.mbds.news.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mbds.news.R
import com.mbds.news.adapters.ArticleAdapter
import com.mbds.news.model.Article
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ArticleDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ArticleDetailFragment : Fragment() {

    var myValue:String?=null

    override fun onCreateView (
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {







        return inflater.inflate(R.layout.fragment_article_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)



        val artName = view?.findViewById<TextView>(R.id.article_name)
        val artAuthor = view?.findViewById<TextView>(R.id.article_author)
        val artDate = view?.findViewById<TextView>(R.id.article_date)
        val artLink = view?.findViewById<TextView>(R.id.article_link)
        val artContent = view?.findViewById<TextView>(R.id.article_content)
        val imageView = view?.findViewById<ImageView>(R.id.article_image)

        val imageUrl=arguments?.getString("urlToimage")

        artName?.setText(arguments?.getString("title"))
        artAuthor?.setText("Author : "+arguments?.getString("author"))
        artDate?.setText("DD/MM/YYYY")
        artLink?.setText("Link to he article:  "+arguments?.getString("url"))
        artContent?.setText(arguments?.getString("content"))




        Glide
            .with(view)
            .load(imageUrl)
            .centerInside()
            .placeholder(R.drawable.placeholder)
            .into(imageView);



    }




    companion object {
        fun newInstance(title:String, urlToimage:String, content:String, author:String, url:String):ArticleDetailFragment {
            val fragment= ArticleDetailFragment()
            val args = Bundle()
            args.putString("title",title)
            args.putString("urlToimage",urlToimage)
            args.putString("content",content)
            args.putString("author",author)
            args.putString("url",url)

            fragment.arguments=args
            return fragment
        }
    }




}