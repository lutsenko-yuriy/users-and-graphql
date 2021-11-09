package com.yurich.graphqlmonstrousity.data.network.service

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.coroutines.toDeferred
import com.yurich.graphqlmonstrousity.PostsRequestQuery
import com.yurich.graphqlmonstrousity.domain.Post
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkPostServiceWrapper @Inject constructor(
    private val client: ApolloClient
) : PostDataSource {

    override suspend fun getPosts(pageNumber: Int, pageSize: Int): List<Post> {
        TODO("Not yet implemented")
    }

    override suspend fun getDetailedPost(postId: String): Post {
        TODO("Not yet implemented")
    }
}