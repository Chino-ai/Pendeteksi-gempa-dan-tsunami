package com.example.pendeteksigempadantsunami.ui.edukasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pendeteksigempadantsunami.R
import com.example.pendeteksigempadantsunami.databinding.ActivityEdukasiBinding

class EdukasiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        edukasiBinding = ActivityEdukasiBinding.inflate(layoutInflater)
        setContentView(edukasiBinding.root)
    }

    private lateinit var edukasiBinding: ActivityEdukasiBinding
}