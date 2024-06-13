package com.rajeev.vridblog.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.rajeev.vrid_blogapplication.database.asDomainModel
import com.rajeev.vrid_blogapplication.domain.BlogList
import com.rajeev.vridblog.database.BlogDatabase
import com.rajeev.vrid_blogapplication.network.BlogService
import com.rajeev.vridblog.network.model.asDatabaseModel
import javax.inject.Inject

class BlogListRepository @Inject constructor(
    private val service: BlogService,
    private val database: BlogDatabase
) {

    val blogs: LiveData<List<BlogList>?> = database.blogsDao.getAll().map { it?.asDomainModel() }

    suspend fun refreshBlogs() {
        try {
            val blogs = service.getBlogList()
            database.blogsDao.insertAll(blogs.asDatabaseModel())
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}