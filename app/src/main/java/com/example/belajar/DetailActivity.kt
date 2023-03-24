package com.example.belajar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.belajar.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity(){

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(home())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.ic_home -> replaceFragment(home())
                R.id.ic_riwayat -> replaceFragment(riwayat())
                R.id.ic_mycourse -> replaceFragment(myCourse())
                R.id.ic_jobfind -> replaceFragment(jobFind())
                R.id.ic_profil -> replaceFragment(profil())
            else ->{

                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}