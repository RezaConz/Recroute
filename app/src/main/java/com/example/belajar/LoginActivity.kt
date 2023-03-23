package com.example.belajar

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var MasukanEmail: EditText
    private lateinit var MasukanPassword: EditText
    private lateinit var Login: Button
    private lateinit var progressDialog: ProgressDialog

    private fun initComponent() {
        MasukanEmail = findViewById(R.id.masukanEmail)
        MasukanPassword = findViewById(R.id.masukanPassword)
        Login = findViewById(R.id.Login)
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Logging")
        progressDialog.setMessage("Mohon tunggu")
    }

    var firebaseAuth = FirebaseAuth.getInstance()

    override fun onStart() {
        super.onStart()
        if (firebaseAuth.currentUser!=null){
            startActivity(Intent(this, DetailActivity::class.java))
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initComponent()

        Login.setOnClickListener{
            if (MasukanEmail.text.isNotEmpty() && MasukanPassword.text.isNotEmpty()){
                prosesLogin()
            }else{
                Toast.makeText( this, "Silahkan isi email dan password terlebih dahulu", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun prosesLogin(){
        val email = MasukanEmail.text.toString()
        val password = MasukanPassword.text.toString()
        progressDialog.show()

        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                startActivity(Intent(this, DetailActivity::class.java))
            }
            .addOnFailureListener { error ->
                Toast.makeText(this, error.localizedMessage, Toast.LENGTH_SHORT).show()
            }
            .addOnCompleteListener {
                progressDialog.dismiss()
            }
    }
}