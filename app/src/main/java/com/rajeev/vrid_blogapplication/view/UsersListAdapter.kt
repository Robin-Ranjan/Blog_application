package com.rajeev.vrid_blogapplication.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rajeev.vrid_blogapplication.databinding.BlogCardBinding
import com.rajeev.vrid_blogapplication.domain.BlogList

class UsersListAdapter(
    private val context: Context,
    private val blogs: List<BlogList>,
    private val clickListener: (BlogList) -> Unit,
) :
    ListAdapter<BlogList, UsersListAdapter.ViewHolder>(UsersListDiffCallback()) {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = blogs[position]
        holder.bind(item, clickListener,context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(private val binding: BlogCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: BlogList, clickListener: (BlogList) -> Unit,context: Context) {
            binding.root.setOnClickListener {
                clickListener.invoke(item)
            }
            binding.txtDate.text = item.createdAt
            binding.txtTitle.text = item.title
            binding.txtAuthor.text = item.authorName
            Glide.with(context).load(item.thumbnail).centerCrop().into(binding.ivProfile)
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = BlogCardBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class UsersListDiffCallback : DiffUtil.ItemCallback<BlogList>() {

    override fun areItemsTheSame(oldItem: BlogList, newItem: BlogList): Boolean {
        return oldItem.link == newItem.link
    }

    override fun areContentsTheSame(oldItem: BlogList, newItem: BlogList): Boolean {
        return oldItem == newItem
    }

}