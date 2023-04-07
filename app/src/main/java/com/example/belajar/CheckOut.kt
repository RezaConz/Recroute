package com.example.belajar

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getSystemService
import com.example.belajar.databinding.FragmentCheckOutBinding
class CheckOut : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentCheckOutBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCheckOutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backNotifikasi.setOnClickListener(this)
        binding.buttonBayar.setOnClickListener(this)
        binding.copyButton.setOnClickListener(this)
        binding.petunjuKPembayaran.setOnClickListener(this)
//        binding.copyButton.setOnClickListener {
//            val myClipboard: ClipboardManager = DetailActivity.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
//            val myClip: ClipData
//        }
    }

    override fun onClick(v: View) {
        if (v.id == R.id.backNotifikasi){
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(
                    R.id.frame_layout,
                    Pembayaran(),
                    Pembayaran::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        }
        if (v.id == R.id.buttonBayar) {
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
        if (v.id == R.id.petunjuKPembayaran) {
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(
                    R.id.frame_layout,
                    WebViewCaraPembayaran(),
                    WebViewCaraPembayaran::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        }
    }
}