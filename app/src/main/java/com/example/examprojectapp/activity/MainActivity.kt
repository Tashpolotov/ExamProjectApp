package com.example.examprojectapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import com.example.examprojectapp.R
import com.example.examprojectapp.databinding.ActivityMainBinding
import com.example.examprojectapp.fragments.ExamFragment
import com.example.examprojectapp.fragments.HomeFragment
import com.example.examprojectapp.fragments.LeaderboardFragment
import com.example.examprojectapp.fragments.OnBoardFragment
import com.example.examprojectapp.utils.Preferences
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    private lateinit var onBoardingCompletedKey: String
    @Inject
    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        onBoardingCompletedKey = "onBoardingCompleted"
        setContentView(binding.root)

        if (savedInstanceState == null) {
            if (!preferences.isBoardingShow()) {
                supportFragmentManager.beginTransaction().add(R.id.fr_container, OnBoardFragment())
                    .commit()
                binding.bottomNavView.visibility = View.GONE
            }

            else {
                supportFragmentManager.beginTransaction()
                    .add(R.id.fr_container, HomeFragment()).commit()
                binding.bottomNavView.visibility = View.VISIBLE
            }
        }

        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        val bottomMenu = binding.bottomNavView

        val iconColorSelector = ContextCompat.getColorStateList(this, R.color.bottom_icon_colors)
        bottomMenu.itemIconTintList = iconColorSelector

        binding.bottomNavView.setOnItemSelectedListener {

            when(it.itemId){

                R.id.menu_item_home ->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fr_container, HomeFragment())
                        .addToBackStack(null)
                        .commit()
                    true

                }
                R.id.menu_item_exam ->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fr_container, ExamFragment())
                        .addToBackStack(null)
                        .commit()
                    true
                }
                R.id.menu_item_statistic ->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fr_container, LeaderboardFragment())
                        .addToBackStack(null)
                        .commit()
                    true
                }
                else -> false
            }
        }

    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(onBoardingCompletedKey, preferences.isBoardingShow())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        preferences.setBoardingShow(savedInstanceState.getBoolean(onBoardingCompletedKey, false))
    }
    override fun onBackPressed() {
        finish()
    }

}