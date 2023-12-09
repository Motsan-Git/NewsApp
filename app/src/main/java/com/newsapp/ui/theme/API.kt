package com.newsapp.ui.theme

import com.newsapp.ResponseModel
import com.newsapp.Source
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface API {
    @GET("top-headlines")
    suspend fun getNews(
        @Query("sources") source: String,
        @Query("apikey") apikey: String
    ): Response<ResponseModel>
}