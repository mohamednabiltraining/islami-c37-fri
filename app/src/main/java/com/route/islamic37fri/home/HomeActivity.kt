package com.route.islamic37fri.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.route.islamic37fri.R
import com.route.islamic37fri.databinding.ActivityHomeBinding
import com.route.islamic37fri.home.hadeth.HadethFragment
import com.route.islamic37fri.home.quran.QuranFragment
import com.route.islamic37fri.home.radio.RadioFragment
import com.route.islamic37fri.home.tasbeh.TasbehFragment

class HomeActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initViews()
        viewBinding.content.homeBottomNavigation.selectedItemId = R.id.nav_quran
    }

    private fun initViews() {
        viewBinding.content.homeBottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_quran -> {
                    showFragment(QuranFragment())
                }
                R.id.nav_hadeth -> {
                    showFragment(HadethFragment())
                }
                R.id.nav_radio -> {
                    showFragment(RadioFragment())
                }
                R.id.nav_tasbeh -> {
                    showFragment(TasbehFragment())
                }
            }
            return@setOnItemSelectedListener true;
        }
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}