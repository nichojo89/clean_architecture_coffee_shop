package com.nicholssoftware.cleansolidarchcoffee.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.nicholssoftware.cleansolidarchcoffee.R
import com.nicholssoftware.cleansolidarchcoffee.databinding.ActivityMainBinding
import com.nicholssoftware.cleansolidarchcoffee.framework.MainViewModel
import com.nicholssoftware.cleansolidarchcoffee.framework.UseCases
import com.nicholssoftware.cleansolidarchcoffee.framework.db.DrinkEntity
import com.nicholssoftware.cleansolidarchcoffee.framework.di.ApplicationModule
import com.nicholssoftware.cleansolidarchcoffee.framework.di.DaggerViewModelComponent
import com.nicholssoftware.core.data.Drink
import dagger.android.DaggerActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private val binding get() = _binding
    private lateinit var _binding: ActivityMainBinding
    private val viewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        _binding.bottomNav.setupWithNavController(navController)

        val root = _binding.root
        setContentView(root)

        viewModel.bootStrap()
    }
}