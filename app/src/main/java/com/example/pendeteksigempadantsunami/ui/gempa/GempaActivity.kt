package com.example.pendeteksigempadantsunami.ui.gempa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pendeteksigempadantsunami.databinding.ActivityGempaBinding
import com.example.pendeteksigempadantsunami.ui.sectionpager.SectionPager

class GempaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        gempaBinding = ActivityGempaBinding.inflate(layoutInflater)
        setContentView(gempaBinding.root)

        sectionPagerAdapter = SectionPager(this, supportFragmentManager)
        gempaBinding.viewPager.adapter = sectionPagerAdapter
        gempaBinding.tabs.setupWithViewPager(gempaBinding.viewPager)
        supportActionBar?.elevation = 0f
    }

    private lateinit var gempaBinding: ActivityGempaBinding
    private lateinit var sectionPagerAdapter: SectionPager
}