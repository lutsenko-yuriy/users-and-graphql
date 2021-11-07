package com.yurich.mapsapp.presentation.list.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yurich.mapsapp.R
import com.yurich.mapsapp.domain.Post

class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    lateinit var post: Post
        private set

    private val title: TextView = itemView.findViewById(R.id.post_title)
    private val body: TextView = itemView.findViewById(R.id.post_body)

    fun bind(post: Post) {
        this.post = post

        this.title.text = post.title
        this.body.text = post.body
    }

}