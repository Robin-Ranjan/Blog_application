package com.rajeev.vrid_blogapplication.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rajeev.vrid_blogapplication.domain.BlogList

@Entity
data class DatabaseBlogListItem(
    @PrimaryKey val id: Int,
    val thumbnail: String,
    val authorName: String,
    val title: String,
    val createdAt: String,
    val link: String
)

fun List<DatabaseBlogListItem>.asDomainModel(): List<BlogList> {
    return map {
        BlogList(
            thumbnail = it.thumbnail,
            authorName = it.authorName,
            title = it.title,
            createdAt = it.createdAt,
            link = it.link
        )
    }
}