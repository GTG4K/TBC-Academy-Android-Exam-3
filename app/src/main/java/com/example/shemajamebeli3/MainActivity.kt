package com.example.shemajamebeli3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shemajamebeli3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()
    }

    fun setup() {
        binding.apply {
            btnGame9.setOnClickListener { }
            btnGame16.setOnClickListener { }
            btnGame25.setOnClickListener { }
        }
    }
}