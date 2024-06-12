package com.rajeev.vridblog.network.model

import com.google.gson.annotations.SerializedName
import com.rajeev.vrid_blogapplication.database.DatabaseBlogListItem

data class BlogResponseDto(
    @SerializedName("id") var id: Int,
    @SerializedName("date") var date: String,
    @SerializedName("status") var status: String,
    @SerializedName("link") var link: String,
    @SerializedName("title") var title: Title,
    @SerializedName("format") var format: String,
    @SerializedName("jetpack_featured_media_url") var jetpackFeaturedMediaUrl: String
) {
    data class Title(
        @SerializedName("rendered") var rendered: String
    )
}

fun List<BlogResponseDto>.asDatabaseModel(): List<DatabaseBlogListItem> {
    return map {
        DatabaseBlogListItem(
            id = it.id,
            thumbnail = it.jetpackFeaturedMediaUrl,
            authorName = it.jetpackFeaturedMediaUrl,
            title = it.title.rendered,
            createdAt = it.date,
            link = it.link
        )
    }
}