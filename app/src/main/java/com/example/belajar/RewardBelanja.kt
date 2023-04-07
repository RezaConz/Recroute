package com.example.belajar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.belajar.databinding.FragmentRewardBelanjaBinding
import com.example.belajar.databinding.FragmentRewardBinding
import com.google.firebase.auth.FirebaseAuth

class RewardBelanja : Fragment(), View.OnClickListener{
    private lateinit var binding : FragmentRewardBelanjaBinding
    lateinit var auth : FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRewardBelanjaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()
        val user = auth.currentUser

        if (user != null){
            binding.RewardUname.text = user.displayName
        }
        binding.rewardEdukasi.setOnClickListener(this)
        binding.rewardMakanan.setOnClickListener(this)
        binding.rewardBelanja.setOnClickListener(this)
        binding.rewardSemua.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.rewardEdukasi) {
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(
                    R.id.frame_layout,
                    RewardEdukasi(),
                    RewardEdukasi::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        }
        if (v.id == R.id.rewardBelanja) {
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(
                    R.id.frame_layout,
                    RewardBelanja(),
                    RewardBelanja::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        }
        if (v.id == R.id.rewardMakanan) {
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(
                    R.id.frame_layout,
                    RewardMakanan(),
                    RewardMakanan::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        }
        if (v.id == R.id.rewardSemua) {
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(
                    R.id.frame_layout,
                    Reward(),
                    Reward::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        }
    }
}