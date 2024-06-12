package com.rajeev.vridblog.network

import com.rajeev.vridblog.network.model.BlogResponseDto
import retrofit2.http.GET

interface BlogService {

    @GET("¬wp-json/wp/v2/posts")
    suspend fun getBlogList(): List<BlogResponseDto>
}