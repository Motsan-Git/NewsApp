package com.newsapp.Activity

import android.graphics.ColorFilter
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import androidx.activity.ComponentActivity
import androidx.compose.ui.graphics.Color
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.newsapp.model.News
import com.newsapp.adaptor.NewsAdaptor
import com.newsapp.R
import com.newsapp.API.API
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    private val newsList = mutableListOf<News>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialRecView()
        lifecycleScope.launch {
            val progressBar=findViewById<ProgressBar>(R.id.progressBar)
            progressBar.isVisible = true
            val response =
                Retrofit.Builder().baseUrl("https://newsapi.org/v2/").addConverterFactory(
                    GsonConverterFactory.create()
                ).build().create(API::class.java)
                    .getNews("techcrunch", "033965c13e684defa143721f0bb71e9d")
            if (response.isSuccessful && response.body() != null) {
                newsList.addAll(response.body()!!.articles)
                initialRecView()
                progressBar.isVisible = false
            } else
                Log.e("chekResponse", "noting")
        }
    }



    private fun initialRecView() {
        val recView = findViewById<RecyclerView>(R.id.recView)
        val newsAdaptor = NewsAdaptor(newsList, this)
        recView.adapter = newsAdaptor
        recView.layoutManager = LinearLayoutManager(this)
        val dividerItemDecoration=
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recView.addItemDecoration(dividerItemDecoration)
    }
}



