package com.example.belajar

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var alamatEmail: EditText
    private lateinit var Pwz: EditText
    private lateinit var HalLogin: Button
    private lateinit var register: TextView
    private lateinit var progressDialog: ProgressDialog

    private fun initComponent() {
        alamatEmail = findViewById(R.id.alamatEmail)
        Pwz = findViewById(R.id.Pwz)
        HalLogin = findViewById(R.id.HalLogin)
        register = findViewById(R.id.register_login)
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

        HalLogin.setOnClickListener{
            if (alamatEmail.text.isNotEmpty() && Pwz.text.isNotEmpty()){
                prosesLogin()
            }else{
                Toast.makeText( this, "Silahkan isi email dan password terlebih dahulu", Toast.LENGTH_SHORT).show()
            }
        }

        register.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun prosesLogin(){
        val email = alamatEmail.text.toString()
        val password = Pwz.text.toString()
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