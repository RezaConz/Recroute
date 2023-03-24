package com.example.belajar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth

class Walktrough3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walktrough3)

        val buttonWt3 = findViewById<Button>(R.id.buttonWt3)
        buttonWt3.setOnClickListener {
            val intent = Intent (this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    var firebashAuth = FirebaseAuth.getInstance()
    override fun onStart() {
        super.onStart()
        if (firebashAuth.currentUser != null) {
            startActivity(Intent(this, DetailActivity::class.java))
        }
    }
}