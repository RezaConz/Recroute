package com.example.belajar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.belajar.databinding.FragmentPopupDiskonBinding
import com.example.belajar.databinding.FragmentPromoBinding

class Promo : Fragment(), View.OnClickListener {
    private lateinit var binding : FragmentPromoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPromoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.kembaliPembayaran.setOnClickListener(this)
        binding.BackPromo.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.kembaliPembayaran) {
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(
                    R.id.frame_layout,
                    Pembayaran(),
                    Pembayaran::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        }
        if (v.id == R.id.BackPromo) {
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(
                    R.id.frame_layout,
                    Pembayaran(),
                    Pembayaran::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        }
    }
}