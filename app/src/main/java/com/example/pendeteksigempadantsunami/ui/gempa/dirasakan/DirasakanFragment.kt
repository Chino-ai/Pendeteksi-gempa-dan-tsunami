package com.example.pendeteksigempadantsunami.ui.gempa.dirasakan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pendeteksigempadantsunami.databinding.FragmentDirasakanBinding

class DirasakanFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dirasakanBinding = FragmentDirasakanBinding.inflate(layoutInflater)
        return dirasakanBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private lateinit var dirasakanBinding: FragmentDirasakanBinding

}