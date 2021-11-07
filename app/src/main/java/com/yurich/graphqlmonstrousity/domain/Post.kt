package com.yurich.graphqlmonstrousity.domain

data class Post(
    val id: String,
    val title: String,
    val body: String,
    val User: User
)
