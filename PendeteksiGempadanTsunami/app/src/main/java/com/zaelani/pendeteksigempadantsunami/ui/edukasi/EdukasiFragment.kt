package com.zaelani.pendeteksigempadantsunami.ui.edukasi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.zaelani.pendeteksigempadantsunami.R

class EdukasiFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_edukasi, container, false)
        val textView: TextView = root.findViewById(R.id.text_edukasi)
        textView.text = "This is edukasi Fragment"
        return root
    }
}