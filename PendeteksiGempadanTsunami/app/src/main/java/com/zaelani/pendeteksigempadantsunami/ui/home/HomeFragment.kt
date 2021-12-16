package com.zaelani.pendeteksigempadantsunami.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mapbox.mapboxsdk.annotations.MarkerOptions
import com.mapbox.mapboxsdk.camera.CameraPosition
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.maps.Style
import com.zaelani.pendeteksigempadantsunami.databinding.FragmentHomeBinding
import com.zaelani.pendeteksigempadantsunami.viewmodel.ViewModelFactory


class HomeFragment : Fragment() {

    private var _fragmentHomeBinding : FragmentHomeBinding? = null
    private val fragmentHomeBinding get() = _fragmentHomeBinding!!

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
                    tvPotensiOrDirasakan.text = gempaTerkini.potensi
                }
                val coordinates = gempaTerkini.coordinates.split(",")
                val Lat = coordinates[0].toDouble()
                val Lng = coordinates[1].toDouble()

                savedInstanceState?.let { fragmentHomeBinding.mapView.onSaveInstanceState(it) }
                setMap(Lat, Lng)
            })
        }
    }

    private fun setMap(lat: Double, lng: Double) {
        fragmentHomeBinding.mapView.getMapAsync{
            it.setStyle(Style.TRAFFIC_DAY)

            val location = LatLng(lat, lng)
            val position = CameraPosition.Builder()
                .target(location)
                .zoom(6.0)
                .bearing(10.0)
                .tilt(10.0)
                .build()

            it.animateCamera(CameraUpdateFactory.newCameraPosition(position), 1000)
            it.addMarker(MarkerOptions().setPosition(location))
        }
    }

    private fun showProgressBar(state: Boolean) {
        fragmentHomeBinding.progressBar.visibility = if (state) View.VISIBLE else View.GONE
    }

    // lifecycle
    override fun onStart() {
        super.onStart()
        fragmentHomeBinding.mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        fragmentHomeBinding.mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        fragmentHomeBinding.mapView.onPause()
    }

    override fun onStop() {
        super.onStop()
        fragmentHomeBinding.mapView.onStop()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        fragmentHomeBinding.mapView.onSaveInstanceState(outState)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        fragmentHomeBinding.mapView.onLowMemory()
    }

    override fun onDestroy() {
        super.onDestroy()
        _fragmentHomeBinding = null
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentHomeBinding.mapView.onDestroy()
    }
}