package com.example.belajar

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.belajar.databinding.FragmentHamburgerBinding
import com.example.belajar.databinding.FragmentHomeBinding
import com.google.firebase.auth.FirebaseAuth

class HamburgerFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentHamburgerBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHamburgerBinding.inflate(inflater,container,false)
        return binding.root
    }
    var firebaseAuth = FirebaseAuth.getInstance()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.back.setOnClickListener(this)
        binding.mycourseHamburger.setOnClickListener(this)
        binding.pesananHamburger.setOnClickListener(this)
        binding.notifHamburger.setOnClickListener(this)
        binding.rewardHamburger.setOnClickListener(this)
        binding.logoutHamburger.setOnClickListener(this)
    }
     override fun onClick(v: View) {
        if (v.id == R.id.back) {
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(
                    R.id.frame_layout,
                    home(),
                    home::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        }else if(v.id == R.id.mycourse_hamburger){
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(
                    R.id.frame_layout,
                    CourseFragment(),
                    CourseFragment::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        }else if(v.id == R.id.pesanan_hamburger){
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(
                    R.id.frame_layout,
                    PesananFragment(),
                    PesananFragment::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        }else if(v.id == R.id.notif_hamburger){
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(
                    R.id.frame_layout,
                    NotifFragment(),
                    NotifFragment::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        }else if(v.id == R.id.reward_hamburger){
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(
                    R.id.frame_layout,
                    RewardFragment(),
                    RewardFragment::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        }else if(v.id == R.id.logout_hamburger){
            firebaseAuth.signOut()
            startActivity(Intent(context, LoginActivity::class.java))
            activity?.finish()
        }
    }
}