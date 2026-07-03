package com.vcyberpunk.news.data.remote.api

import com.vcyberpunk.news.data.remote.entity.NewsResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("v2/everything")
    suspend fun loadArticles(
        @Query("q") topic: String,
        @Query("language") language: String
    ): NewsResponseDto

}