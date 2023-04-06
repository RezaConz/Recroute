package com.example.belajar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.belajar.databinding.FragmentDaftarmodulBinding

class DaftarmodulFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentDaftarmodulBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDaftarmodulBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.userinterfaceButton.setOnClickListener(this)
        binding.userinterfaceButton.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.userinterface_button) {
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(
                    R.id.frame_layout,
                    UserinterfacedesignFragment(),
                    UserinterfacedesignFragment::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        }else if (v.id == R.id.backMyCourse) {
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(
                    R.id.frame_layout,
                    CourseFragment(),
                    CourseFragment::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        }
    }

}