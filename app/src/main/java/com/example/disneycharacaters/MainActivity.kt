package com.example.disneycharacaters

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment
import com.example.disneycharacaters.databinding.ActivityMainBinding
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAnalytics: FirebaseAnalytics
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        firebaseAnalytics = Firebase.analytics
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.disneyFragment) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.disneyFragment -> navController.navigate(R.id.disneyFragment)
                R.id.disneyInfoFragment -> navController.navigate(R.id.disneyInfoFragment)
                else -> {
                }
            }

            true
        }
        navController.addOnDestinationChangedListener{_,destingation,_->
            if(destingation.id==R.id.disneyDetailFragment){
                binding.bottomNavigation.visibility = View.GONE
            }
            else{
                binding.bottomNavigation.visibility = View.VISIBLE
            }
        }


    }
}
