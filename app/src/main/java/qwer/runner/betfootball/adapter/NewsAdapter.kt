package qwer.runner.betfootball.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import qwer.runner.betfootball.databinding.ItemNewsBinding
import qwer.runner.betfootball.model.NewsModel

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    var newsList: List<NewsModel> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = newsList[position]
        holder.bind(news)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    class NewsViewHolder(private val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(news: NewsModel) {
            binding.newsTitle.text = news.title
            binding.newsDesc.text = news.desc
        }
    }
}
