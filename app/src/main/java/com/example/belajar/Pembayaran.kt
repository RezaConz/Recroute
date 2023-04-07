package com.example.belajar

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.belajar.databinding.FragmentPembayaranBinding
import com.example.belajar.databinding.FragmentWebdeveloperBinding
import com.google.firebase.auth.FirebaseAuth

class Pembayaran : Fragment(), View.OnClickListener {

    private lateinit var binding : FragmentPembayaranBinding
    lateinit var auth : FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPembayaranBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.pembayaranKodePromo.setOnClickListener {
//            val builder = AlertDialog.Builder(this)
//            val view = layoutInflater.inflate(R.layout.fragment_popup_diskon,null)
//            builder.setView(view)
//        }
        auth = FirebaseAuth.getInstance()
        val user = auth.currentUser

        if (user != null){
            binding.namaPembayaran.text = user.displayName
            binding.emailPembayaran.text = user.email
        }
        binding.buttonpembayaran.setOnClickListener(this)
        binding.Backpembayaran.setOnClickListener(this)
        binding.pembayaranKodePromo.setOnClickListener(this)
        binding.pembayaraMetodePembayaran.setOnClickListener(this)
    }

    @SuppressLint("MissingInflatedId")
    override fun onClick(v: View) {
        if (v.id == R.id.buttonpembayaran) {
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(
                    R.id.frame_layout,
                    CheckOut(),
                    CheckOut::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        }
        if (v.id == R.id.Backpembayaran) {
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(
                    R.id.frame_layout,
                    DetailKelas(),
                    DetailKelas::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        }
        if (v.id == R.id.pembayaranKodePromo) {
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(
                    R.id.frame_layout,
                    Promo(),
                    Promo::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        }
        if (v.id == R.id.pembayaraMetodePembayaran) {
            val builder = AlertDialog.Builder(requireContext())
            val view = layoutInflater.inflate(R.layout.popup_metode_pembayaran,null)
            builder.setView(view)
            val dialog = builder.create()

            view.findViewById<Button>(R.id.pilih_metode).setOnClickListener {
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
                dialog.dismiss()
            }
            if (dialog.window != null){
                dialog.window!!.setBackgroundDrawable(ColorDrawable(0))
            }
            dialog.show()
        }
    }
}