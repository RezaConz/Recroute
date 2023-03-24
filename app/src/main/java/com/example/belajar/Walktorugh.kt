package com.example.belajar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth

class Walktorugh : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walktorugh)

        val buttonWt1 = findViewById<Button>(R.id.buttonWt1)
        buttonWt1.setOnClickListener {
            val intent = Intent (this, Walktrough2::class.java)
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