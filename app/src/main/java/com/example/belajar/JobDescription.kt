package com.example.belajar

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context.CLIPBOARD_SERVICE
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.belajar.databinding.FragmentJobDescriptionBinding
import com.example.belajar.databinding.FragmentJobFinder2Binding

class JobDescription : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentJobDescriptionBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentJobDescriptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backDeskripsi.setOnClickListener(this)
        binding.buttonLamar.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.backDeskripsi){
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(
                    R.id.frame_layout,
                    JobFinder2(),
                    JobFinder2::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        }
        if (v.id == R.id.buttonLamar){
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(
                    R.id.frame_layout,
                    JobApplication(),
                    JobApplication::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        }
    }
}