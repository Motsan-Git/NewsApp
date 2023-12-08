package com.newsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsAdaptor(var newsList: MutableList<News>) :
    RecyclerView.Adapter<NewsAdaptor.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
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
            titel.text = newsList[position].titel
            description.text = newsList[position].description
            dateAndWriter.text = newsList [position].date + " " + newsList[position].writer
            //image.text = newsList[position].titel
        }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }


}
