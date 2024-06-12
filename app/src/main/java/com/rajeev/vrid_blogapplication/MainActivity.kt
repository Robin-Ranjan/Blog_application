package com.rajeev.vrid_blogapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rajeev.vrid_blogapplication.databinding.ActivityMainBinding
import com.rajeev.vrid_blogapplication.databinding.FragmentWebViewBinding
import com.rajeev.vrid_blogapplication.view.BlogsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding:ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().replace(binding.container.id,BlogsFragment()).commit()
    }
}