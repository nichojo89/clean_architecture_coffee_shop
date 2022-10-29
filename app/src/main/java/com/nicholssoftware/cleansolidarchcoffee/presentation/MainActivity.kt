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
import com.nicholssoftware.cleansolidarchcoffee.framework.UseCases
import com.nicholssoftware.cleansolidarchcoffee.framework.di.ApplicationModule
import com.nicholssoftware.cleansolidarchcoffee.framework.di.DaggerViewModelComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private val binding get() = _binding
    private lateinit var _binding: ActivityMainBinding

    @Inject
    lateinit var useCases: UseCases

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        _binding.bottomNav.setupWithNavController(navController)

        val root = _binding.root
        setContentView(root)
    }
}