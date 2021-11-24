package com.example.pendeteksigempadantsunami.ui.sectionpager

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.pendeteksigempadantsunami.R
import com.example.pendeteksigempadantsunami.ui.gempa.dirasakan.DirasakanFragment
import com.example.pendeteksigempadantsunami.ui.gempa.magnitudo.MagnitudoFragment
import com.example.pendeteksigempadantsunami.ui.gempa.terkini.TerkiniFragment


class SectionPager(private val mContext : Context,fm: FragmentManager) : FragmentPagerAdapter(fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.dirasakan, R.string.terkini,R.string.magnitudo)
    }

    override fun getItem(position : Int): Fragment =
        when (position) {
            0 -> DirasakanFragment()
            1 -> TerkiniFragment()
            2 -> MagnitudoFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence? = mContext.resources.getString(TAB_TITLES[position])


    override fun getCount(): Int = 3

}