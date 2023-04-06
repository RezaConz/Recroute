package com.example.belajar

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.belajar.databinding.ActivityDetailBinding
import com.example.belajar.databinding.ActivityMaindrawerBinding
import com.example.belajar.databinding.FragmentHomeBinding
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

//        setSupportActionBar(binding.toolbar)
//        val toggle = ActionBarDrawerToggle(this, binding.drawerLayout,R.string.OpenDrawer,R.string.CloseDrawer)
//        binding.drawerLayout.addDrawerListener(toggle)
//        toggle.syncState()
    }
//    override fun onBackPressed() {
//        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
//            binding.drawerLayout.closeDrawer(GravityCompat.START)
//        } else {
//            super.onBackPressed()
//        }
//    }
    fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }

}