package com.rajeev.vrid_blogapplication.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.rajeev.vrid_blogapplication.databinding.FragmentWebViewBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class WebViewFragment : Fragment() {

    private lateinit var binding: FragmentWebViewBinding

    private val link by lazy {
        arguments?.getString(KEY_LINK)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWebViewBinding.inflate(layoutInflater, null, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        link?.let { binding.webView.loadUrl(it) }
        binding.webView.getSettings().setJavaScriptEnabled(true);
        binding.webView.webViewClient = WebViewClient()
    }

    companion object {
        const val TAG = "WebViewFragment"
        private const val KEY_LINK = "KEY_LINKS"

        fun newInstance(link: String) = WebViewFragment().apply {
            this.arguments = Bundle().apply {
                getString(KEY_LINK, link)
            }
        }
    }
}