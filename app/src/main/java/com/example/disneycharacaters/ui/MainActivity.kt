package com.example.disneycharacaters.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment
import com.example.disneycharacaters.R
import com.example.disneycharacaters.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(binding.launchScreen.id) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavBar.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.itemCharacters -> {
                    navController.navigate(R.id.itemCharacters)
                }
                R.id.itemGames -> {
                    navController.navigate(R.id.itemGames)
                }
                else -> {}
            }
            true
        }

    }
}