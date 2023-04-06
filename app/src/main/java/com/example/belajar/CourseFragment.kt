package com.example.belajar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.belajar.databinding.FragmentCourseBinding

class CourseFragment : Fragment(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private lateinit var binding: FragmentCourseBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCourseBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.courseAktif1.setOnClickListener(this)
        binding.courseSelesaiButton.setOnClickListener(this)
        binding.notifCourseAktif.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.courseAktif_1) {
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(
                    R.id.frame_layout,
                    DaftarmodulFragment(),
                    DaftarmodulFragment::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        }else if (v.id == R.id.course_selesai_button) {
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(
                    R.id.frame_layout,
                    CourseselesaiFragment(),
                    CourseselesaiFragment::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        }else if (v.id == R.id.notif_course_aktif) {
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