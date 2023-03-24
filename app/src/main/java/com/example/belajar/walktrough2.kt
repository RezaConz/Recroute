package com.example.belajar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class walktrough2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walktrough2)

        val buttonWt2 = findViewById<Button>(R.id.buttonWt2)
        buttonWt2.setOnClickListener {
            val intent = Intent (this, walktrough3::class.java)
            startActivity(intent)
        }
    }
}