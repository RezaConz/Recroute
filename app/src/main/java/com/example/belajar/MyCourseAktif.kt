package com.example.belajar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.belajar.databinding.FragmentMyCourseAktifBinding

class MyCourseAktif : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentMyCourseAktifBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMyCourseAktifBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.MyCourseAktif.setOnClickListener(this)
        binding.MyCourseComplete.setOnClickListener(this)
        binding.notification.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.MyCourseAktif){
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(
                    R.id.frame_layout,
                    MyCourseSelesai(),
                    MyCourseSelesai::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        }
        if (v.id == R.id.MyCourseComplete){
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(
                    R.id.frame_layout,
                    DaftarModul(),
                    DaftarModul::class.java.simpleName
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