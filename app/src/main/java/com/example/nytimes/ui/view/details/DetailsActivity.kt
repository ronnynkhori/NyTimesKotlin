package com.example.nytimes.ui.view.details

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.nytimes.R


class DetailsActivity : AppCompatActivity() {
    private lateinit var titleTxt: TextView
    private lateinit var descriptionTxt: TextView
    private lateinit var author: TextView
    private lateinit var dateTxt: TextView
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_article_details)

        val bundle = intent.extras

        titleTxt = findViewById(R.id.title_detail)
        descriptionTxt = findViewById(R.id.abstract_detail)
        author = findViewById(R.id.author_detail)
        dateTxt = findViewById(R.id.date_detail)
        imageView = findViewById(R.id.image_detail)


        if (bundle != null) {
            titleTxt.text = bundle.getString("title")
            descriptionTxt.text = bundle.getString("abstract")
            author.text = bundle.getString("author")
            dateTxt.text = bundle.getString("date")
            Glide.with(this)
                .load(bundle.getString("image"))
                .centerCrop()
                .into(imageView)
        } else {
            Log.d("ERROR", "Empty Bundle")
        }

    }

}