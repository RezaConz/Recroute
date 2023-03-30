package com.example.belajar

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import com.example.belajar.databinding.FragmentMyCourseBinding
import com.example.belajar.databinding.FragmentWebdeveloperBinding

class myCourse : Fragment(), View.OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private lateinit var bindind : FragmentMyCourseBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindind = FragmentMyCourseBinding.inflate(inflater,container,false)
        return bindind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindind.webDev.setOnClickListener (this)
//        bindind.webDev.setOnClickListener {
//            fragmentManager?.beginTransaction()?.apply {
//                replace(
//                    R.id.Frame_mycourse,
//                    WebdeveloperFragment(),
//                    WebdeveloperFragment::class.java.simpleName)
//                    .addToBackStack(null)
//                    .commit()
//            }
//        }
    }

    override fun onClick(v: View) {
        if (v.id == R.id.webDev) {
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(
                    R.id.Frame_mycourse,
                    WebdeveloperFragment(),
                    WebdeveloperFragment::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        }
    }
}