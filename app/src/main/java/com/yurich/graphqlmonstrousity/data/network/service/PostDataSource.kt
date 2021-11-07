package com.yurich.graphqlmonstrousity.data.network.service

import com.yurich.graphqlmonstrousity.domain.Post

interface PostDataSource {
    suspend fun getVehicles(): List<Post>
}