package com.yurich.graphqlmonstrousity.data.network.service

import com.yurich.graphqlmonstrousity.domain.Post
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkPostServiceWrapper @Inject constructor(
    ): PostDataSource {

    override suspend fun getVehicles(): List<Post> {
        TODO("Implement")
    }

}