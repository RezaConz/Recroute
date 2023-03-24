package com.example.belajar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class walktorugh : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walktorugh)

        val buttonWt1 = findViewById<Button>(R.id.buttonWt1)
        buttonWt1.setOnClickListener {
            val intent = Intent (this, walktrough2::class.java)
            startActivity(intent)
        }
    }
}