package com.example.belajar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.belajar.databinding.FragmentUjianakhirBinding

class UjianakhirFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentUjianakhirBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUjianakhirBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nextKerjakan.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.nextKerjakan) {
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(
                    R.id.frame_layout,
                    SoalujianFragment(),
                    SoalujianFragment::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        }
    }
}