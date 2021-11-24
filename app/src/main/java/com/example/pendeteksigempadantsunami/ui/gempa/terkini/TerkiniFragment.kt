package com.example.pendeteksigempadantsunami.ui.gempa.terkini

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pendeteksigempadantsunami.R
import com.example.pendeteksigempadantsunami.databinding.FragmentTerkiniBinding


class TerkiniFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        terkiniBinding = FragmentTerkiniBinding.inflate(layoutInflater)
        return terkiniBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private lateinit var terkiniBinding: FragmentTerkiniBinding
}