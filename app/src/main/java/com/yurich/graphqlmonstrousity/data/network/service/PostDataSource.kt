package com.yurich.graphqlmonstrousity.data.network.service

import com.yurich.graphqlmonstrousity.domain.Post

interface PostDataSource {
    suspend fun getPosts(pageNumber: Int, pageSize: Int): List<Post>
    suspend fun getDetailedPost(postId: String): Post
}