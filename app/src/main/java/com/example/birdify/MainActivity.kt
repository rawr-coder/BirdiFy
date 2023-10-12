package com.example.birdify

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.birdify.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.widget.Toolbar
import com.google.firebase.FirebaseApp

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        FirebaseApp.initializeApp(this)

        val navView = findViewById<BottomNavigationView>(R.id.nav_view)
        val appBarConfiguration = AppBarConfiguration.Builder(
            R.id.navigation_home,
            R.id.navigation_Hotspot,
            R.id.navigation_Sightings,
            R.id.navigation_settings
        ).build()

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        // Set the ActionBar (Toolbar)
        setSupportActionBar(toolbar)

        // Set up ActionBar with NavController
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
        NavigationUI.setupWithNavController(navView, navController)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
