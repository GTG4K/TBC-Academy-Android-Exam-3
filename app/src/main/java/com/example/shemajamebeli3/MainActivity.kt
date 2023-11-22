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
            btnGame9.setOnClickListener {
                val gameFragment = GameFragment.newInstance(3)
                supportFragmentManager.beginTransaction()
                    .replace(android.R.id.content, gameFragment)
                    .addToBackStack(null)
                    .commit()
            }
            btnGame16.setOnClickListener {
                val gameFragment = GameFragment.newInstance(4)
                supportFragmentManager.beginTransaction()
                    .replace(android.R.id.content, gameFragment)
                    .addToBackStack(null)
                    .commit()
            }
            btnGame25.setOnClickListener {
                val gameFragment = GameFragment.newInstance(5)
                supportFragmentManager.beginTransaction()
                    .replace(android.R.id.content, gameFragment)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }
}