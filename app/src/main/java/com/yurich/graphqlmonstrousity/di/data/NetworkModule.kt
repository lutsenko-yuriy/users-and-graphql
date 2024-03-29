package com.yurich.graphqlmonstrousity.di.data

import com.apollographql.apollo.ApolloClient
import com.yurich.graphqlmonstrousity.data.network.service.NetworkPostServiceWrapper
import com.yurich.graphqlmonstrousity.data.network.service.PostDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun apolloClient(): ApolloClient =
        ApolloClient.builder()
            .serverUrl("https://graphqlzero.almansi.me/api")
            .build()

    @Provides
    @Singleton
    fun service(client: ApolloClient): PostDataSource =
        NetworkPostServiceWrapper(client)

}