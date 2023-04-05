package com.example.belajar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.belajar.databinding.ActivityMaindrawerBinding
import com.example.belajar.databinding.FragmentHomeBinding
import com.example.belajar.databinding.FragmentMyCourseBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [home.newInstance] factory method to
 * create an instance of this fragment.
 */
class home : Fragment(), View.OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        requireActivity().onBackPressedDispatcher.addCallback(this,object :OnBackPressedCallback(true){
//            override fun handleOnBackPressed(){
//                if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)){
//                    binding.drawerLayout.closeDrawer(GravityCompat.START)
//                }
//            }
//        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        bindingdrawer = ActivityMaindrawerBinding.inflate(inflater, container, false)

//        (activity as AppCompatActivity).setSupportActionBar(bindingdrawer.toolbar)
//        val toggle = ActionBarDrawerToggle(requireActivity(), bindingdrawer.drawerLayout,R.string.OpenDrawer,R.string.CloseDrawer)
//        bindingdrawer.drawerLayout.addDrawerListener(toggle)
//        toggle.syncState()

        binding.hamburger.setOnClickListener(this)
    }

     override fun onClick(v: View) {
        if (v.id == R.id.hamburger) {
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(
                    R.id.frame_layout,
                    HamburgerFragment(),
                    HamburgerFragment::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        }
    }
}