package com.riki.ta.ui.activity

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.riki.ta.R
import com.riki.ta.ui.fragment.JadwalKuliahFragment
import com.riki.ta.ui.fragment.ProfileFragment
import com.ogaclejapan.smarttablayout.BuildConfig
import com.ogaclejapan.smarttablayout.SmartTabLayout
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems
import kotlinx.android.synthetic.main.activity_main.*

class DataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = FragmentPagerItemAdapter(
            supportFragmentManager, FragmentPagerItems.with(this)
                .add("Jadwal Kuliah", JadwalKuliahFragment::class.java)
                .add("Profil", ProfileFragment::class.java)
                .create()
        )

        val viewPager = findViewById(R.id.viewpager) as ViewPager
        viewPager.adapter = adapter

        val viewPagerTab = findViewById(R.id.viewpagertab) as SmartTabLayout
        viewPagerTab.setViewPager(viewPager)
    }
}