package com.newsapp.API

import com.newsapp.model.ResponseModel
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