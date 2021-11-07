package com.yurich.mapsapp.data.network.service

import com.yurich.mapsapp.domain.Post

interface PostDataSource {
    suspend fun getVehicles(): List<Post>
}