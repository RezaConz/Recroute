package com.example.belajar

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.example.belajar.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.userProfileChangeRequest

class MainActivity : AppCompatActivity() {

    private lateinit var MasukanUsername:EditText
    private lateinit var MasukanEmail:EditText
    private lateinit var MasukanPassword:EditText
    private lateinit var MasukanConfirmPassword:EditText
    private lateinit var Daftar:Button
    private lateinit var Login:Button
    private lateinit var progressDialog: ProgressDialog

    private fun initComponent() {
        MasukanUsername = findViewById(R.id.masukanUsername)
        MasukanEmail = findViewById(R.id.masukanEmail)
        MasukanPassword = findViewById(R.id.masukanPassword)
        MasukanConfirmPassword = findViewById(R.id.MasukanConfirmPassword)
        Daftar = findViewById(R.id.Daftar)
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
        setContentView(R.layout.activity_main)
        initComponent()
        Login.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        Daftar.setOnClickListener {
            if (MasukanUsername.text.isNotEmpty()&&MasukanEmail.text.isNotEmpty()&&MasukanPassword.text.isNotEmpty()){
                if (MasukanPassword.text.toString()==MasukanConfirmPassword.text.toString()){
                    prosesRegister()
                }else{
                    Toast.makeText( this, "Password tidak sama", LENGTH_SHORT).show()
                }
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