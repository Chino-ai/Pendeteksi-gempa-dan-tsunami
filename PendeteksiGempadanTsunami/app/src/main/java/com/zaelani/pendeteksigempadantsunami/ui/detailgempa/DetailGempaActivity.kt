package com.zaelani.pendeteksigempadantsunami.ui.detailgempa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.annotations.MarkerOptions
import com.mapbox.mapboxsdk.camera.CameraPosition
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.maps.Style
import com.zaelani.pendeteksigempadantsunami.R
import com.zaelani.pendeteksigempadantsunami.data.local.entity.DirasakanEntity
import com.zaelani.pendeteksigempadantsunami.data.local.entity.MagnitudoEntity
import com.zaelani.pendeteksigempadantsunami.databinding.ActivityDetailGempaBinding

class DetailGempaActivity : AppCompatActivity() {

    private var _activityDetailGempa : ActivityDetailGempaBinding? = null
    private val activityDetailGempaBinding get() = _activityDetailGempa!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Mapbox.getInstance(this, getString(R.string.access_token))
        _activityDetailGempa = ActivityDetailGempaBinding.inflate(layoutInflater)
        setContentView(activityDetailGempaBinding.root)
        supportActionBar?.title = "Detail Gempa"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        savedInstanceState?.let { activityDetailGempaBinding.mapView.onSaveInstanceState(it) }

        val fromActivityMagnitudo = intent.getBooleanExtra(EXTRA_FROM_MAGNITUDE, false)
        if(fromActivityMagnitudo){
            val gempa = intent.getParcelableExtra<MagnitudoEntity>(EXTRA_DETAIL_GEMPA)
            with(activityDetailGempaBinding.detailGempa){
                tvTanggal.text = gempa?.tanggal
                tvJam.text = gempa?.jam
                tvMagnitude.text = gempa?.magnitude
                tvDepth.text = gempa?.kedalaman
                tvCoordinate.text = gempa?.lintang + " " + gempa?.bujur
                tvWilayah.text = gempa?.wilayah
                tvPotensiOrDirasakan.text = gempa?.potensi
            }
            val coordinates = gempa?.coordinates?.split(",")
            val Lat = coordinates?.get(0)?.toDouble()
            val Lng = coordinates?.get(1)?.toDouble()
            setMap(Lat, Lng)
        }else{
            val gempa = intent.getParcelableExtra<DirasakanEntity>(EXTRA_DETAIL_GEMPA)
            with(activityDetailGempaBinding.detailGempa){
                imageView.setImageResource(R.drawable.ic_dirasakan_30)
                tvTanggal.text = gempa?.tanggal
                tvJam.text = gempa?.jam
                tvMagnitude.text = gempa?.magnitude
                tvDepth.text = gempa?.kedalaman
                tvCoordinate.text = gempa?.lintang + " " + gempa?.bujur
                tvWilayah.text = gempa?.wilayah
                tvPotensiOrDirasakan.text = gempa?.dirasakan
            }
            val coordinates = gempa?.coordinates?.split(",")
            val Lat = coordinates?.get(0)?.toDouble()
            val Lng = coordinates?.get(1)?.toDouble()
            setMap(Lat, Lng)
        }
    }

    private fun setMap(lat: Double?, lng: Double?) {
        activityDetailGempaBinding.mapView.getMapAsync{
            it.setStyle(Style.TRAFFIC_DAY)

            val location = lat?.let { it1 -> lng?.let { it2 -> LatLng(it1, it2) } }
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

    companion object {
        const val EXTRA_DETAIL_GEMPA = "extra_detail_gempa"
        const val EXTRA_FROM_MAGNITUDE = "extra_from_magnitude"
    }

    // lifecycle
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onStart() {
        super.onStart()
        activityDetailGempaBinding.mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        activityDetailGempaBinding.mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        activityDetailGempaBinding.mapView.onPause()
    }

    override fun onStop() {
        super.onStop()
        activityDetailGempaBinding.mapView.onStop()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        activityDetailGempaBinding.mapView.onSaveInstanceState(outState)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        activityDetailGempaBinding.mapView.onLowMemory()
    }

    override fun onDestroy() {
        super.onDestroy()
        activityDetailGempaBinding.mapView.onDestroy()
        _activityDetailGempa = null
    }
}