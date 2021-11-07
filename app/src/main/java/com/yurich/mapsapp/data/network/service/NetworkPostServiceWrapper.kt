package com.yurich.mapsapp.data.network.service

import com.yurich.mapsapp.domain.Post
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkPostServiceWrapper @Inject constructor(
    ): PostDataSource {

    override suspend fun getVehicles(): List<Post> {
        TODO("Implement")
    }

}