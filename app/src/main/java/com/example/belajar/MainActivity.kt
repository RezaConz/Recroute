package com.example.belajar

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.example.belajar.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var MasukanUsername:EditText
    private lateinit var MasukanEmail:EditText
    private lateinit var MasukanPassword:EditText
    private lateinit var Daftar:Button
    private lateinit var Login:TextView
    private lateinit var progressDialog: ProgressDialog

    private fun initComponent() {
        MasukanUsername = findViewById(R.id.masukanUsername)
        MasukanEmail = findViewById(R.id.masukanEmail)
        MasukanPassword = findViewById(R.id.masukanPassword)
        Daftar = findViewById(R.id.Daftar)
        Login = findViewById(R.id.Login_main)
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Logging")
        progressDialog.setMessage("Mohon tunggu")

        database = FirebaseDatabase.getInstance().getReference("Users")
    }

    var firebaseAuth = FirebaseAuth.getInstance()
    private lateinit var database: DatabaseReference


    override fun onStart() {
        super.onStart()
        if (firebaseAuth.currentUser!=null){
            startActivity(Intent(this, DetailActivity::class.java))
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponent()

        Login.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        Daftar.setOnClickListener {
            if (MasukanUsername.text.isNotEmpty()&&MasukanEmail.text.isNotEmpty()&&MasukanPassword.text.isNotEmpty()){
                val User = User(MasukanUsername.text.toString(),MasukanEmail.text.toString())
                database.child(MasukanUsername.text.toString()).setValue(User)
                prosesRegister()
            }else{
                Toast.makeText( this, "Data belum lengkap terisi", LENGTH_SHORT).show()
            }
        }
    }

    private  fun prosesRegister(){
        val fullname = MasukanUsername.text.toString()
        val email = MasukanEmail.text.toString()
        val password = MasukanPassword.text.toString()
        progressDialog.show()

        firebaseAuth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful){
                    val userUpdateProfile = userProfileChangeRequest {
                        displayName = fullname
                    }
                    val user = task.result.user
                    user!!.updateProfile(userUpdateProfile)
                        .addOnSuccessListener {
                            progressDialog.dismiss()
                            startActivity(Intent(this, MainActivity::class.java))
                        }
                        .addOnFailureListener{ error2 ->
                            Toast.makeText(this, error2.localizedMessage, LENGTH_SHORT).show()
                        }
                }else{
                    progressDialog.dismiss()
                }
            }
            .addOnFailureListener{ error ->
                Toast.makeText(this, error.localizedMessage, LENGTH_SHORT).show()
            }
    }
}