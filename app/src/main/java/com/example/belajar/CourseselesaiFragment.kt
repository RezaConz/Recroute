package com.example.belajar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.belajar.databinding.FragmentCourseBinding
import com.example.belajar.databinding.FragmentCourseselesaiBinding


class CourseselesaiFragment : Fragment(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private lateinit var binding: FragmentCourseselesaiBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCourseselesaiBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.courseAktifButton.setOnClickListener(this)
        binding.notifCourseSelesai.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.course_aktif_button) {
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
        }else if (v.id == R.id.notif_course_selesai) {
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