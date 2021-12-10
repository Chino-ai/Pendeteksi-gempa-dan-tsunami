package com.zaelani.pendeteksigempadantsunami.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.zaelani.pendeteksigempadantsunami.databinding.FragmentHomeBinding
import com.zaelani.pendeteksigempadantsunami.viewmodel.ViewModelFactory


class HomeFragment : Fragment() {

    private var _fragmentHomeBinding : FragmentHomeBinding? = null
    val fragmentHomeBinding get() = _fragmentHomeBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _fragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return fragmentHomeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            showProgressBar(true)

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[HomeViewModel::class.java]
            viewModel.getGempaTerkini().observe(viewLifecycleOwner, { gempaTerkini ->
                showProgressBar(false)
                with(fragmentHomeBinding.detailGempa) {
                    tvTanggal.text = gempaTerkini.tanggal
                    tvJam.text = gempaTerkini.jam
                    tvMagnitude.text = gempaTerkini.magnitude
                    tvDepth.text = gempaTerkini.kedalaman
                    tvCoordinate.text = gempaTerkini.lintang + " " + gempaTerkini.bujur
                    tvWilayah.text = gempaTerkini.wilayah
                    tvPotensiTsunami.text = gempaTerkini.potensi
                }
                Glide.with(this)
                        .load("https://data.bmkg.go.id/DataMKG/TEWS/" + gempaTerkini.shakemap)
                        .into(fragmentHomeBinding.imgShakemap)
            })
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _fragmentHomeBinding = null
    }

    private fun showProgressBar(state: Boolean) {
        if (state) {
            fragmentHomeBinding.progressBar.visibility = View.VISIBLE
        } else {
            fragmentHomeBinding.progressBar.visibility = View.GONE
        }
    }
}