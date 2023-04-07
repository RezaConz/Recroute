package com.example.belajar

import android.app.AlertDialog
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.belajar.databinding.FragmentSoalujianBinding
import java.time.Duration

class SoalujianFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentSoalujianBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSoalujianBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nextKirim.setOnClickListener(this)


        val timer = object: CountDownTimer(20000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
//                mTextField.setText("seconds remaining: " + millisUntilFinished / 1000)

            }

            override fun onFinish() {

            }
        }
        timer.start()
    }

    override fun onClick(v: View) {
        if (v.id == R.id.nextKirim) {
            val builder = AlertDialog.Builder(requireContext())
            val view = layoutInflater.inflate(R.layout.ujian_selesai,null)
            builder.setView(view)
            val dialog = builder.create()

            view.findViewById<Button>(R.id.back_ujian_selesai).setOnClickListener {
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
            if (dialog.window != null){
                dialog.window!!.setBackgroundDrawable(ColorDrawable(0))
            }
            dialog.show()
        }
    }

}