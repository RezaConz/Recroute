package com.example.belajar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.belajar.databinding.FragmentJobFinder2Binding
import com.example.belajar.databinding.FragmentJobFinderBinding

class JobFinder : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentJobFinderBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentJobFinderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.JobFinderTerkirim.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.JobFinderTerkirim){
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
    }
}