package com.example.belajar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.belajar.databinding.FragmentRewardBinding
import com.google.firebase.auth.FirebaseAuth

class Reward : Fragment(){//, View.OnClickListener {

    private lateinit var binding : FragmentRewardBinding
    lateinit var auth : FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRewardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()
        val user = auth.currentUser

        if (user != null){
            binding.RewardUname.text = user.displayName
        }
//        binding.buttonpembayaran.setOnClickListener(this)
//        binding.Backpembayaran.setOnClickListener(this)
//        binding.pembayaranKodePromo.setOnClickListener(this)
//        binding.pembayaraMetodePembayaran.setOnClickListener(this)
    }

//    override fun onClick(v: View) {
//        if (v.id == R.id.buttonpembayaran) {
//            val mFragmentManager = parentFragmentManager
//            mFragmentManager.beginTransaction().apply {
//                replace(
//                    R.id.frame_layout,
//                    CheckOut(),
//                    CheckOut::class.java.simpleName
//                )
//                addToBackStack(null)
//                commit()
//            }
//        }
//        if (v.id == R.id.Backpembayaran) {
//            val mFragmentManager = parentFragmentManager
//            mFragmentManager.beginTransaction().apply {
//                replace(
//                    R.id.frame_layout,
//                    DetailKelas(),
//                    DetailKelas::class.java.simpleName
//                )
//                addToBackStack(null)
//                commit()
//            }
//        }
//        if (v.id == R.id.pembayaranKodePromo) {
//            val mFragmentManager = parentFragmentManager
//            mFragmentManager.beginTransaction().apply {
//                replace(
//                    R.id.frame_layout,
//                    PopupDiskon(),
//                    PopupDiskon::class.java.simpleName
//                )
//                addToBackStack(null)
//                commit()
//            }
//        }
//        if (v.id == R.id.pembayaraMetodePembayaran) {
//            val mFragmentManager = parentFragmentManager
//            mFragmentManager.beginTransaction().apply {
//                replace(
//                    R.id.frame_layout,
//                    PopUpMetodePembayaran(),
//                    PopUpMetodePembayaran::class.java.simpleName
//                )
//                addToBackStack(null)
//                commit()
//            }
//        }
//    }
}