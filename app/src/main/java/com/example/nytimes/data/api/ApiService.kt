package com.example.nytimes.data.api

import com.example.nytimes.data.model.Article
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/svc/mostpopular/v2/viewed/7.json")
    fun getArticles(@Query("api-key") key: String): Call<Article>
}