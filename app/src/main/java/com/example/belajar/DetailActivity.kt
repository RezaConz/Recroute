package com.example.belajar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.belajar.databinding.ActivityDetailBinding
import com.example.belajar.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    val firebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}