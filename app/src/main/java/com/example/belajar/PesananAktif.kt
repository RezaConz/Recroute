package com.example.belajar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.belajar.databinding.FragmentMyCourseSelesaiBinding
import com.example.belajar.databinding.FragmentPesananAktifBinding

class PesananAktif : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentPesananAktifBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPesananAktifBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.PesananAktif.setOnClickListener(this)
        binding.notification.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.PesananAktif){
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(
                    R.id.frame_layout,
                    PesananSelesai(),
                    PesananSelesai::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        }
        if (v.id == R.id.notification){
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(
                    R.id.frame_layout,
                    Notifikasi(),
                    Notifikasi::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        }
    }
}