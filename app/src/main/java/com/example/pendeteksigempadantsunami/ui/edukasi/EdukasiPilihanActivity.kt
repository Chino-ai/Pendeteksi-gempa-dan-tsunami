package com.example.pendeteksigempadantsunami.ui.edukasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pendeteksigempadantsunami.databinding.ActivityEdukasiBinding
import com.example.pendeteksigempadantsunami.databinding.ActivityEdukasiPilihanBinding

class EdukasiPilihanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        edukasiBindingPilihan = ActivityEdukasiPilihanBinding.inflate(layoutInflater)
        setContentView(edukasiBindingPilihan.root)
    }

    lateinit var edukasiBindingPilihan: ActivityEdukasiPilihanBinding
}