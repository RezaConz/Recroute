package com.example.belajar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth

class Walktrough2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walktrough2)

        val buttonWt2 = findViewById<Button>(R.id.buttonWt2)
        buttonWt2.setOnClickListener {
            val intent = Intent (this, Walktrough3::class.java)
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