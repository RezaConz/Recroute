package com.example.belajar

import android.app.AlertDialog
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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
        if (v.id == R.id.backLamaran) {
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
        if (v.id == R.id.unduhTemplate) {
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
        if (v.id == R.id.kirim) {
            val builder = AlertDialog.Builder(requireContext())
            val view = layoutInflater.inflate(R.layout.popup_lamaran, null)
            builder.setView(view)
            val dialog = builder.create()

            view.findViewById<Button>(R.id.buttonPopupLamaran).setOnClickListener {
                val mFragmentManager = parentFragmentManager
                mFragmentManager.beginTransaction().apply {
                    replace(
                        R.id.frame_layout,
                        home(),
                        home::class.java.simpleName
                    )
                    addToBackStack(null)
                    commit()
                }
                dialog.dismiss()
            }
            if (dialog.window != null) {
                dialog.window!!.setBackgroundDrawable(ColorDrawable(0))
            }
            dialog.show()
        }
    }
}