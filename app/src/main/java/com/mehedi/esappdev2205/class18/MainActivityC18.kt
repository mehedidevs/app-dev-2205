package com.mehedi.esappdev2205.class18

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.mehedi.esappdev2205.R
import com.mehedi.esappdev2205.databinding.ActivityMainC17Binding

class MainActivityC18 : AppCompatActivity() {

    lateinit var binding: ActivityMainC17Binding
    lateinit var navController: NavController
    lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainC17Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar.root)
        val drawerLayout = binding.drawerLayout
        val navView = binding.navigationView
        navController = findNavController(R.id.fragmentContainerView)


        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.profileFragment,
                R.id.userFragment
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, drawerLayout)
        navView.setupWithNavController(navController)

    }


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.top_menu, menu)

        return true
    }


}