package com.example.nytimes.ui.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nytimes.ui.view.details.DetailsActivity
import com.example.nytimes.R
import com.example.nytimes.data.model.Result
import com.example.nytimes.data.model.Media


class Adapter(val context: Context, val articles: List<Result>) :
    RecyclerView.Adapter<CustomViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        var itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false)
        return CustomViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        val article = articles.get(position)

        holder.article = article
        holder.title.text = article.title
        holder.description.text = article.abstract
        holder.author.text = article.byline
        article.media.firstOrNull()?.getMetaData(Media.MediaSize.THUMB)?.let {
            Glide.with(context)
                .load(it.url)
                .centerCrop()
                .into(holder.image)
        }
    }

    override fun getItemCount(): Int {
        return articles.count()
    }

}

class CustomViewHolder(val view: View, var article: Result? = null) :
    RecyclerView.ViewHolder(view) {
    var image: ImageView
    var title: TextView
    var description: TextView
    var author: TextView


    init {
        image = itemView.findViewById(R.id.item_article_image)
        title = itemView.findViewById(R.id.item_article_title)
        description = itemView.findViewById(R.id.item_post_description)
        author = itemView.findViewById(R.id.item_post_author)


        itemView.setOnClickListener(View.OnClickListener {

            val intent = Intent(view.context, DetailsActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("title",article?.title)
            intent.putExtra("author", article?.byline)
            intent.putExtra("date", article?.published_date)
            intent.putExtra("abstract", article?.abstract)
            article?.media?.firstOrNull()?.getMetaData(Media.MediaSize.NORMAL)?.let {
                intent.putExtra("image", it.url)
            }

            view.context.startActivity(intent)
        })
    }
}



