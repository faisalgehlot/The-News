package com.faisalgehlot.thenews

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.faisalgehlot.thenews.databinding.NewsLayoutBinding

class NewsListAdapter(private val listener: NewsItemClicked): RecyclerView.Adapter<NewsListViewHolder>() {

    private val items: ArrayList<News> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListViewHolder {
        val view = NewsLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewHolder = NewsListViewHolder(view)

        return NewsListViewHolder(view)

    }

    override fun onBindViewHolder(holder: NewsListViewHolder, position: Int) {
        val currentItem = items[position]
        holder.newsTitle.text = currentItem.title
        holder.newsAuthor.text = currentItem.author
        Glide.with(holder.itemView.context).load(currentItem.imageUrl).into(holder.newsImage)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateNews(updatedNews: ArrayList<News>) {
        items.clear()
        items.addAll(updatedNews)

        notifyDataSetChanged()
    }

}

class NewsListViewHolder constructor (binding: NewsLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
    var newsImage = binding.newsImageView
    var newsTitle = binding.newsTitleView
    var newsAuthor = binding.newsAuthorView
}

interface NewsItemClicked {
    fun onItemClicked(items: News)
}




