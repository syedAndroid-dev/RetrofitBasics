package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

class RecyclerAdapter(private val newsList: List<Article>) :RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val uiTvNewsTitle:TextView? = itemView.findViewById(R.id.uiTvNewsTitle)!!
        val uiTvNewsName:TextView? = itemView.findViewById(R.id.uiTvNewsName)
        val uiIvNewsImage: ImageView? = itemView.findViewById(R.id.uiIvNewsImage)
        val uiTvNewsDescription:TextView? = itemView.findViewById(R.id.uiTvNewsDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_layout,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemsPosition = newsList[position]
        holder.uiTvNewsTitle?.text = itemsPosition.title
        holder.uiTvNewsName?.text= itemsPosition.author
        holder.uiIvNewsImage?.let {
            Glide.with(it).load(itemsPosition.urlToImage).apply(RequestOptions().diskCacheStrategy(
                DiskCacheStrategy.ALL)).into(holder.uiIvNewsImage)
        }
        holder.uiTvNewsDescription?.text = itemsPosition.description
    }

    override fun getItemCount(): Int {

        return newsList.size
    }
}