package com.nicholssoftware.cleansolidarchcoffee.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.nicholssoftware.cleansolidarchcoffee.R
import com.nicholssoftware.cleansolidarchcoffee.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding get() = _binding
    private lateinit var _binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        _binding.bottomNav.setupWithNavController(navController)

        val root = _binding.root
        setContentView(root)
    }

    /**
     * Handles bottom bar navigation
     */
//    private val _menuActions = NavigationBarView.OnItemSelectedListener { item ->
//        when(item.itemId) {
//            R.id.home -> {
//                HomeFragmentDirections.
//            }
//            R.id.checkout -> {
//            }
//            R.id.about -> {
//
//            }
//        }
//        true
//    }
}