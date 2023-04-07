package com.example.belajar

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.belajar.databinding.FragmentProfilBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.storage.StorageReference

class profil : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentProfilBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReferene: DatabaseReference
    private lateinit var storageReferense: StorageReference
    private lateinit var dialog: Dialog
    private lateinit var user: User
    private lateinit var uid:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfilBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()
        val user = auth.currentUser

        if (user != null){
            binding.usernameProfil.text = user.displayName
            binding.emailUser.text = user.email
        }

        binding.editProfil.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.edit_profil) {
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(
                    R.id.frame_layout,
                    ProfilupdateFragment(),
                    ProfilupdateFragment::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        }
    }
}