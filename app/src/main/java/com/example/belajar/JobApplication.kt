package com.example.belajar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.belajar.databinding.FragmentJobApplicationBinding
import com.example.belajar.databinding.FragmentJobDescriptionBinding

class JobApplication : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentJobApplicationBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentJobApplicationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backLamaran.setOnClickListener(this)
        binding.unduhTemplate.setOnClickListener(this)
        binding.kirim.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.backLamaran){
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(
                    R.id.frame_layout,
                    JobDescription(),
                    JobDescription::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        }
        if (v.id == R.id.unduhTemplate){
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(
                    R.id.frame_layout,
                    WebViewFormulir(),
                    WebViewFormulir::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        }
        if (v.id == R.id.kirim){
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(
                    R.id.frame_layout,
                    PopupLamaran(),
                    PopupLamaran::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        }
    }
}