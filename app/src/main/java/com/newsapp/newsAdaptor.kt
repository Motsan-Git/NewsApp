package com.newsapp

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsAdaptor(var newsList: MutableList<News>, var context: Context) :
    RecyclerView.Adapter<NewsAdaptor.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titel: TextView
        val description: TextView
        val dateAndWriter: TextView
        val image: ImageView

        init {
            view.apply {
                titel = findViewById(R.id.titelTv)
                description = findViewById(R.id.descriptionTv)
                dateAndWriter = findViewById(R.id.datewriterTv)
                image = findViewById(R.id.imageView)
                titel.setOnClickListener {
                    val intent=Intent(context,WebpageActivity::class.java)
                    intent.putExtra("url",newsList[adapterPosition].url)
                    context.startActivity(intent)


                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.items, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            titel.text = newsList[position].title
            description.text = newsList[position].description
            dateAndWriter.text = newsList[position].publishedAt + " " + newsList[position].author
            Glide.with(context).load(newsList[position].urlToImage).into(image)
        }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }


}
