package com.yurich.graphqlmonstrousity.presentation.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.NO_POSITION
import com.yurich.graphqlmonstrousity.R
import com.yurich.graphqlmonstrousity.domain.Post

class PostsListAdapter(
    private val listener: OnPostClickListener
) : PagingDataAdapter<Post, PostViewHolder>(POST_LIST_CALLBACK) {

    private val posts = mutableListOf<Post>()

    override fun getItemCount(): Int = posts.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_single_post, parent, false)
        val vehicleViewHolder = PostViewHolder(view)

        vehicleViewHolder.itemView.setOnClickListener {
            if (vehicleViewHolder.bindingAdapterPosition == NO_POSITION) {
                return@setOnClickListener
            }
            listener.onPostClicked(vehicleViewHolder.post)
        }
        return vehicleViewHolder
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    interface OnPostClickListener {
        fun onPostClicked(post: Post)
    }

    companion object {
        private val POST_LIST_CALLBACK = object : DiffUtil.ItemCallback<Post>() {
            override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean =
                oldItem == newItem
        }
    }

}