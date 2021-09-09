package com.example.nytimes.ui.view.articles

import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.nytimes.R
import com.example.nytimes.data.api.ApiService
import com.example.nytimes.data.model.Article
import com.example.nytimes.ui.adapters.Adapter
import com.example.nytimes.utils.Constants.Companion.API_KEY
import com.example.nytimes.utils.Constants.Companion.BASE_URL
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class ArticlesActivity : AppCompatActivity() {

    lateinit var adapter: Adapter
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var recyclerView: RecyclerView
    lateinit var swipeView: SwipeRefreshLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.article_rv)
        recyclerView.setHasFixedSize(true);

        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager


        getMyData();


    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.getItemId()

        if (id == R.id.search) {
            return true
        }

        if (id == R.id.exit_item) {
            return true
        }

        return super.onOptionsItemSelected(item)

    }

    fun getMyData() {
        swipeView = findViewById(R.id.refreshContainer);
        swipeView.setColorSchemeResources(
            R.color.warn,
            R.color.danger,
            R.color.colorSecondary,
            R.color.teal_700
        );
        swipeView.isRefreshing = true

        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiService::class.java)

        val retrofitData = retrofitBuilder.getArticles(API_KEY)

        retrofitData.enqueue(object : Callback<Article?> {
            override fun onResponse(call: Call<Article?>, response: Response<Article?>) {
                val responseBody = response.body()!!

                adapter = Adapter(baseContext, responseBody.results)
                adapter.notifyDataSetChanged()
                recyclerView.adapter = adapter
                swipeView.isRefreshing = false
            }

            override fun onFailure(call: Call<Article?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }


}