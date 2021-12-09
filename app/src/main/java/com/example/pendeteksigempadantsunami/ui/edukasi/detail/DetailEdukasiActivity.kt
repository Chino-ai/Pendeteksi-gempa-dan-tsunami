package com.example.pendeteksigempadantsunami.ui.edukasi.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pendeteksigempadantsunami.R
import com.example.pendeteksigempadantsunami.databinding.ActivityDetailEdukasiBinding

class DetailEdukasiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailEdukasiBinding = ActivityDetailEdukasiBinding.inflate(layoutInflater)
        setContentView(detailEdukasiBinding.root)
    }
    private lateinit var detailEdukasiBinding: ActivityDetailEdukasiBinding

}