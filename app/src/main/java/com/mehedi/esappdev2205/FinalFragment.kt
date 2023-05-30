package com.mehedi.esappdev2205

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mehedi.esappdev2205.databinding.FragmentFinalBinding

class FinalFragment : Fragment() {

    lateinit var binding: FragmentFinalBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment

        binding = FragmentFinalBinding.inflate(layoutInflater, container, false)

        binding.goHomeBtn.setOnClickListener {

            findNavController().navigate(R.id.action_finalFragment_to_homeFragment)


        }



        return binding.root
    }

}