package com.aregyan.github.views.userList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rajeev.vridblog.repository.BlogListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BlogListViewModel @Inject constructor(
    private val repository: BlogListRepository
) : ViewModel() {

    val data = repository.blogs

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.refreshBlogs()
        }
    }

}