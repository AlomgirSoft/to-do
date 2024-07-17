package com.inteligenixsolutions.roomdmi.ui.activity

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.inteligenixsolutions.roomdmi.R


class MainActivity : AppCompatActivity() {


    lateinit var navigationView:NavigationView
    lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var drawerLayout: DrawerLayout
    lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        setUpNavigationDrawer()
        setSupportActionBar(findViewById(R.id.toolbar))
        navController = findNavController(R.id.fragmentContainerView)
        appBarConfigurationSetUp()
        setupActionBarWithNavController(navController, drawerLayout)
        navigationView.setupWithNavController(navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun appBarConfigurationSetUp() {
        appBarConfiguration =
            AppBarConfiguration
                .Builder(
                    R.id.taskFragment,
                    R.id.statisticsFragment
                ).setOpenableLayout(drawerLayout)
                .build()
    }

    private fun setUpNavigationDrawer() {
        navigationView = findViewById(R.id.nav_view)
        drawerLayout = findViewById<DrawerLayout?>(R.id.drawer_layout)
            .apply {
                setStatusBarBackground(R.color.black)
            }
    }
}