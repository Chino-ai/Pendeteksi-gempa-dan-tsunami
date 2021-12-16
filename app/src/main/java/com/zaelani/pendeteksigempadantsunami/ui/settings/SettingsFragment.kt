package com.zaelani.pendeteksigempadantsunami.ui.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.zaelani.pendeteksigempadantsunami.R

class SettingsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_settings, container, false)
        childFragmentManager.beginTransaction().add(R.id.settings, MyPreferenceFragment()).commit()
        return root
    }
}