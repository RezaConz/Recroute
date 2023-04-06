package com.example.belajar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.belajar.databinding.ActivityDetailBinding
import com.google.firebase.auth.FirebaseAuth

class DetailActivity : AppCompatActivity(){

    private lateinit var binding: ActivityDetailBinding

    var firebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(home())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.ic_home -> replaceFragment(home())
                R.id.ic_mycourse -> replaceFragment(myCourse())
                R.id.ic_ranking -> replaceFragment(ranking())
                R.id.ic_jobfind -> replaceFragment(JobFinder2())
                R.id.ic_profil -> replaceFragment(profil())
            else ->{

                }
            }
            true
        }

    }

     public fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}