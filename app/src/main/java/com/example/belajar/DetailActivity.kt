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

        binding.bottomNavigationView.setOnNavigationItemReselectedListener {
            when(it.itemId) {
                R.id.text_home-> replaceFragment(home())
                R.id.text_riwayat -> replaceFragment(riwayat())
                R.id.text_mycourse -> replaceFragment(myCourse())
                R.id.text_jobfind -> replaceFragment(jobFind())
                R.id.text_profil -> replaceFragment(profil())
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