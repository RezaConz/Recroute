package com.example.belajar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.belajar.databinding.FragmentJobFinder2Binding
import com.example.belajar.databinding.FragmentMyCourseAktifBinding

class JobFinder2 : Fragment(), View.OnClickListener{
    private lateinit var binding: FragmentJobFinder2Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentJobFinder2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.JobFinderJOB.setOnClickListener(this)
        binding.UXDesigner.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.JobFinderJOB){
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(
                    R.id.frame_layout,
                    JobFinder(),
                    JobFinder::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        }
        if (v.id == R.id.UXDesigner){
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