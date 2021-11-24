package com.example.pendeteksigempadantsunami.ui.gempa.magnitudo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pendeteksigempadantsunami.R
import com.example.pendeteksigempadantsunami.databinding.FragmentMagnitudoBinding


class MagnitudoFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        magnitudoBinding = FragmentMagnitudoBinding.inflate(layoutInflater)
        return magnitudoBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private lateinit var magnitudoBinding: FragmentMagnitudoBinding
}