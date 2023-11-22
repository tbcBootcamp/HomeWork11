package com.example.homework11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.GridLayoutManager
import com.example.homework11.adapters.ImagesAdapter
import com.example.homework11.data.ImagesList
import com.example.homework11.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}