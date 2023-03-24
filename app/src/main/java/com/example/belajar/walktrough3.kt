package com.example.belajar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class walktrough3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walktrough3)

        val buttonWt3 = findViewById<Button>(R.id.buttonWt3)
        buttonWt3.setOnClickListener {
            val intent = Intent (this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}