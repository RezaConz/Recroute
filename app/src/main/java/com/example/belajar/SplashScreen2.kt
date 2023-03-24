package com.example.belajar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreen2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen2)

        val handler = Handler()
        handler.postDelayed({
            val intent = Intent(this, Walktorugh::class.java)
            startActivity(intent)
        },3000)
    }
}