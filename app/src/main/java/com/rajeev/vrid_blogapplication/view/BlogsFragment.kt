package com.rajeev.vrid_blogapplication.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.aregyan.github.views.userList.BlogListViewModel
import com.rajeev.vrid_blogapplication.commitFragment
import com.rajeev.vrid_blogapplication.databinding.FragmentBlogListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BlogsFragment : Fragment() {

    private lateinit var binding: FragmentBlogListBinding

    private val viewModel: BlogListViewModel by viewModels()
    private lateinit var adapter: UsersListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBlogListBinding.inflate(layoutInflater, null, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.data.observe(viewLifecycleOwner) {
            it?.let { list ->
                adapter = UsersListAdapter(requireContext(),list) {
                    requireActivity().supportFragmentManager.commitFragment(
                        Pair(
                            WebViewFragment.newInstance(
                                it.link
                            ), WebViewFragment.TAG
                        )
                    )
                }
                binding.recycler.layoutManager = LinearLayoutManager(requireContext())
                binding.recycler.adapter = adapter
            }
        }
    }


    companion object {
        const val TAG = "BlogsFragment"

        fun newInstance() = BlogsFragment()
    }
}